package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DirectoryTest {
    @Test
    void shouldFindDirectories() {
        // Temp locations are found here: System.getProperty("java.io.tmpdir")

        // Given a test directory structure with files
        List<String> expected = createTestDirectoriesWithFiles();

        // When called
        String root = "";
        final List<String> directories = Directory.findDirectories(root);

        // Then only directories are returned
        MatcherAssert.assertThat(directories, Matchers.equalTo(expected));
    }

    private List<String> createTestDirectoriesWithFiles() {
        List<String> expected = new ArrayList<>();
        final Path level_root;
        try {
            level_root = createDirectoryAndFiles("level_root_", "file1", "file2");
            expected.add(level_root.toFile().getAbsolutePath());

            final Path level1 = createDirectoryAndFiles(level_root, "level_1_", "file3", "file4");
            expected.add(level1.toFile().getAbsolutePath());

            final Path level2 = createDirectoryAndFiles(level1, "level_2_", "file4", "file5");
            expected.add(level2.toFile().getAbsolutePath());

            final Path level3 = createDirectoryAndFiles(level2, "level_3_", "file6", "file7");
            expected.add(level3.toFile().getAbsolutePath());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(level_root)) {
            level_root.toFile().deleteOnExit();

            for (Path file : ds) {
                file.toFile().deleteOnExit();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return expected;
    }


    private Path createDirectoryAndFiles(String prefix, String... files) throws IOException {
        Path level = Files.createTempDirectory(prefix);
        Arrays.stream(files).forEach((f) -> {
            try {
                new File(level.toAbsolutePath() + "/" + f + ".txt").createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return level.toAbsolutePath();
    }

    private Path createDirectoryAndFiles(Path path, String prefix, String... files) throws IOException {
        final Path dir = path.toAbsolutePath();
        Path level = Files.createTempDirectory(dir, prefix);
        Arrays.stream(files).forEach((f) -> {
            try {
                new File(level.toAbsolutePath() + "/" + f + ".txt").createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return level.toAbsolutePath();
    }
}

