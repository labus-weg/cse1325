import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class BoggleGUI {
    private JFrame frame;
    private JTextArea boardInput;
    private JTextArea wordsInput;
    private JTextArea resultsOutput;
    private JButton solveButton;

    private List<Board> boards = new ArrayList<>();
    private Set<Solution> solutions = new TreeSet<>();
    private AtomicInteger currentBoardIndex = new AtomicInteger(0);

    public BoggleGUI() {
        frame = new JFrame("Boggle Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        boardInput = new JTextArea(5, 20);
        wordsInput = new JTextArea(5, 20);
        resultsOutput = new JTextArea(10, 20);
        resultsOutput.setEditable(false);

        solveButton = new JButton("Solve Boggle");
        solveButton.addActionListener(new SolveAction());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.add(new JLabel("Enter Board (e.g., 'ABC DEF GHI')"));
        panel.add(new JScrollPane(boardInput));
        panel.add(new JLabel("Enter Words (one per line)"));
        panel.add(new JScrollPane(wordsInput));
        panel.add(solveButton);

        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(resultsOutput), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class SolveAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            solveBoggle();
        }
    }

    private void solveBoggle() {
        resultsOutput.setText("");
        solutions.clear();
        boards.clear();

        String boardText = boardInput.getText();
        String[] boardLines = boardText.split("\n");

        for (String line : boardLines) {
            String[] rowArray = line.trim().split(" ");
            boards.add(new Board(rowArray));
        }

        List<String> words = new ArrayList<>();
        String wordsText = wordsInput.getText();
        String[] wordsLines = wordsText.split("\n");
        for (String word : wordsLines) {
            words.add(word.trim());
        }

        int numberOfThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            executor.submit(() -> {
                while (true) {
                    int boardIndex = currentBoardIndex.getAndIncrement();
                    if (boardIndex >= boards.size()) {
                        break;
                    }

                    Board board = boards.get(boardIndex);
                    Solver solver = new Solver(board, 30, 60);

                    for (String word : words) {
                        Solution solution = solver.solve(word);
                        if (solution != null) {
                            synchronized (solutions) {
                                solutions.add(solution);
                            }
                        }
                    }
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        for (Solution solution : solutions) {
            resultsOutput.append(solution.toString() + "\n");
        }
        resultsOutput.append("\nFound " + solutions.size() + " solutions\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BoggleGUI::new);
    }
}
