package com.bytedancer.unittestdemo;

import java.io.File;
import java.io.IOException;
import org.junit.*;
import org.junit.rules.*;

// The TemporaryFolder Rule allows creation of files and folders that are deleted
// when the test method finishes(whether it passes or fails).
// By default no exception is thrown if resources cannot be deleted

public class HasTempFolder {

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    // Starting with version 4.13 TemporaryFolder optionally allows strict verification of deleted resources
    // which fails the test with AssertionError if resources cannot be deleted.

    // @Rule
    // public TemporaryFolder folder = TemporaryFolder.builder().assureDeletion().build();

    @Test
    public void testUsingTempFolder() throws IOException {
        File createdFile = folder.newFile("myfile.txt");
        File createdFolder = folder.newFolder("subfolder");
        // ...
    }
}

