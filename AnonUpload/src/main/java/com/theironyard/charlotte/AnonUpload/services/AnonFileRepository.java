package com.theironyard.charlotte.AnonUpload.services;

import com.theironyard.charlotte.AnonUpload.entities.AnonFile;
import org.springframework.data.repository.CrudRepository;

public interface AnonFileRepository extends CrudRepository<AnonFile, Integer> {
}