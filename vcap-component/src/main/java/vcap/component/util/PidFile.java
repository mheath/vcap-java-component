package vcap.component.util;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Mike Heath <elcapo@gmail.com>
 */
public class PidFile implements Closeable {

	private final Path pidFile;
	private final Integer pid;

	public PidFile(String pidFileName) throws IOException {
		final String pidString;
		try {
			// Open the symlink /proc/self and follow symlink to determine pid -- This will only work on Unix based systems.
			final Path pidPath = Paths.get("/proc", "self").toRealPath();
			pidString = pidPath.getFileName().toString();
		} catch (Exception e) {
			pid = null;
			pidFile = null;
			return;
		}
		this.pid = Integer.valueOf(pidString);
		pidFile = Paths.get(pidFileName);
		Files.write(pidFile, pidString.getBytes(), StandardOpenOption.CREATE);
	}

	public Integer getPid() {
		return pid;
	}

	/**
	 * Deletes the pid file.
	 *
	 * @throws IOException if an error occurs deleting the pid file.
	 */
	@Override
	public void close() throws IOException {
		if (pidFile != null) {
			Files.delete(pidFile);
		}
	}
}