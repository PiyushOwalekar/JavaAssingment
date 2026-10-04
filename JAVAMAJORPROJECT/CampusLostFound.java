import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.*;

class InvalidItemException extends Exception {
    public InvalidItemException(String message) {
        super(message);
    }
}

class Item {
    int id;
    String name;
    String category;
    String location;
    String type;
    String status;
    LocalDateTime date;

    Item(int id, String name, String category,
         String location, String type) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.location = location;
        this.type = type;
        this.status = "Open";
        this.date = LocalDateTime.now();
    }

    public String toString() {
        return "ID: " + id +
                " | " + type +
                " | " + name +
                " | " + category +
                " | " + location +
                " | " + status +
                " | " + date;
    }
}

public class CampusLostFound extends JFrame {

    HashMap<Integer, Item> items = new HashMap<>();
    TreeMap<Integer, Item> sortedItems = new TreeMap<>();

    ArrayList<String> history = new ArrayList<>();

    int id = 1;

    JTextArea output;

    CampusLostFound() {

        setTitle("Campus Lost and Found");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel title = new JLabel(
                "Campus Lost and Found System",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 22));

        add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel();

        JButton add = new JButton("Add Item");
        JButton view = new JButton("View Items");
        JButton search = new JButton("Search");
        JButton claim = new JButton("Claim");
        JButton verify = new JButton("Verify");
        JButton historyBtn = new JButton("History");

        panel.add(add);
        panel.add(view);
        panel.add(search);
        panel.add(claim);
        panel.add(verify);
        panel.add(historyBtn);

        add(panel, BorderLayout.SOUTH);

        output = new JTextArea();
        output.setEditable(false);

        add(new JScrollPane(output), BorderLayout.CENTER);

        add.addActionListener(e -> addItem());
        view.addActionListener(e -> viewItems());
        search.addActionListener(e -> searchItem());
        claim.addActionListener(e -> claimItem());
        verify.addActionListener(e -> verifyItem());
        historyBtn.addActionListener(e -> showHistory());
    }

    // ADD ITEM

    void addItem() {

        try {

            String name = JOptionPane.showInputDialog(
                    "Enter item name:"
            );

            if (name == null || name.isEmpty())
                throw new InvalidItemException(
                        "Item name cannot be empty"
                );

            String category = JOptionPane.showInputDialog(
                    "Enter category:"
            );

            String location = JOptionPane.showInputDialog(
                    "Enter location:"
            );

            String[] type = {"Lost", "Found"};

            String itemType = (String) JOptionPane.showInputDialog(
                    this,
                    "Select type:",
                    "Item Type",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    type,
                    type[0]
            );

            Item item = new Item(
                    id,
                    name,
                    category,
                    location,
                    itemType
            );

            items.put(id, item);
            sortedItems.put(id, item);

            history.add(
                    "Item " + id + " added"
            );

            id++;

            JOptionPane.showMessageDialog(
                    this,
                    "Item added successfully!"
            );

        } catch (InvalidItemException e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage()
            );
        }
    }

    // VIEW ITEMS

    void viewItems() {

        output.setText("");

        if (sortedItems.isEmpty()) {

            output.append("No items found.");

            return;
        }

        for (Item item : sortedItems.values()) {

            output.append(item + "\n\n");
        }
    }

    // SEARCH ITEM

    void searchItem() {

        String search = JOptionPane.showInputDialog(
                "Enter item ID:"
        );

        try {

            int searchId = Integer.parseInt(search);

            Item item = items.get(searchId);

            if (item == null) {

                output.setText("Item not found.");

            } else {

                output.setText(item.toString());
            }

        } catch (Exception e) {

            output.setText("Please enter a valid ID.");
        }
    }

    // CLAIM ITEM

    void claimItem() {

        String input = JOptionPane.showInputDialog(
                "Enter Item ID:"
        );

        try {

            int itemId = Integer.parseInt(input);

            Item item = items.get(itemId);

            if (item == null) {

                output.setText("Item not found.");

                return;
            }

            item.status = "Claimed";

            history.add(
                    "Item " + itemId + " claimed"
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Claim submitted!"
            );

        } catch (Exception e) {

            output.setText("Invalid Item ID.");
        }
    }

    // VERIFY ITEM

    void verifyItem() {

        String input = JOptionPane.showInputDialog(
                "Enter Item ID:"
        );

        try {

            int itemId = Integer.parseInt(input);

            Item item = items.get(itemId);

            if (item == null) {

                output.setText("Item not found.");

                return;
            }

            item.status = "Returned";

            history.add(
                    "Item " + itemId + " verified"
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Item verified!"
            );

        } catch (Exception e) {

            output.setText("Invalid Item ID.");
        }
    }

    // HISTORY

    void showHistory() {

        output.setText("----- HISTORY -----\n\n");

        for (String h : history) {

            output.append(h + "\n");
        }
    }

    public static void main(String[] args) {

        CampusLostFound app =
                new CampusLostFound();

        app.setVisible(true);
    }
}