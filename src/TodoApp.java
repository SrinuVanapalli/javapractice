import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TodoApp extends JFrame {

    private static final Path TASKS_FILE = Path.of(System.getProperty("user.dir"), "todoapp-tasks.txt");

    DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> list = new JList<>(model);
    JTextField task = new JTextField(15);

    public TodoApp() {

        JButton add = new JButton("Add");
        JButton delete = new JButton("Delete");

        JPanel top = new JPanel();
        top.add(task);
        top.add(add);

        JPanel bottom = new JPanel();
        bottom.add(delete);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        loadTasks();

        // Add Task
        add.addActionListener(e -> {
            String text = task.getText().trim();
            if (!text.isEmpty()) {
                model.addElement("[ ] " + text);
                task.setText("");
                saveTasks();
            }
        });

        // Delete Task
        delete.addActionListener(e -> {
            int i = list.getSelectedIndex();
            if (i != -1) {
                model.remove(i);
                saveTasks();
            }
        });

        // Double-click to toggle Done / Not Done
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {

                    int i = list.getSelectedIndex();

                    if (i != -1) {

                        String t = model.get(i);

                        if (t.startsWith("[ ] "))
                            model.set(i, "[x] " + t.substring(4));
                        else
                            model.set(i, "[ ] " + t.substring(4));

                        saveTasks();
                    }
                }
            }
        });

        setTitle("To-Do App");
        setSize(400, 300);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveTasks();
                dispose();
                System.exit(0);
            }
        });
        setVisible(true);
    }

    private void loadTasks() {
        if (!Files.exists(TASKS_FILE)) {
            return;
        }

        try {
            List<String> tasks = Files.readAllLines(TASKS_FILE, StandardCharsets.UTF_8);
            for (String savedTask : tasks) {
                if (!savedTask.isBlank()) {
                    model.addElement(savedTask);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Could not load saved tasks.");
        }
    }

    private void saveTasks() {
        List<String> tasks = new ArrayList<>();
        for (int i = 0; i < model.size(); i++) {
            tasks.add(model.get(i));
        }

        try {
            Files.write(TASKS_FILE, tasks, StandardCharsets.UTF_8);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Could not save tasks.");
        }
    }

    public static void main(String[] args) {
        new TodoApp();
    }
}
