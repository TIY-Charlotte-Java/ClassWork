package com.theironyard.charlotte.AnonUpload.controllers;

import com.theironyard.charlotte.AnonUpload.entities.AnonFile;
import com.theironyard.charlotte.AnonUpload.services.AnonFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class AnonFileController {
    @Autowired
    AnonFileRepository files;

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    // multipart file represents the file we're uploading
    // httpservletresponse is how we can modify the response before
    // it is sent back. in this case, we're redirecting.
    public void upload(MultipartFile file, HttpServletResponse response) throws IOException {
        // even though this class name is "File",
        // we are referencing a directory here.
        // the directory is /public/files (with
        // respect to the project root)
        File dir = new File("public/files");

        // this call makes directories if they're missing
        // from the file path we specified in "dir"
        dir.mkdirs();

        // create a new file that starts with "file" (first parameter)
        // ends with whatever filename you specified (second parameter)
        // the new file is going to be in "dir" (third parameter)
        // file-abc123-picture.png
        File f = File.createTempFile("file", file.getOriginalFilename(), dir);

        // this creates an output stream (or a just a way to read the
        // raw contents of the file)
        FileOutputStream fos = new FileOutputStream(f);

        // write to the output stream all of the bytes
        // in the file upload.
        fos.write(file.getBytes());

        // we have the file on our filesystem, now we need a reference
        // to it in our database.
        // first parameter: the name of the temporary file
        // second parameter: the name of the file you uploaded.
        AnonFile anonFile = new AnonFile(f.getName(), file.getOriginalFilename());
        files.save(anonFile);

        // for regular controllers, we would do this:
        // return "redirect:/";

        // this is a restcontroller, so we're doing this instead:
        response.sendRedirect("/");
    }

    @RequestMapping(path = "/files", method = RequestMethod.GET)
    public List<AnonFile> getFiles() {
        return (List<AnonFile>) files.findAll();
    }
}
