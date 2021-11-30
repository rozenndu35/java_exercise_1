import java.util.Scanner;

public class Quit implements Command {

	@Override
	public String name() {
		return "quit";
	}

	@Override
	public boolean run(Scanner scan) {
		System.out.println("Execution de quit");
		return true;
	}

}
