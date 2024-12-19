package View;

import Model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Review1 extends JFrame {
    private User currentUser;
    private JSplitPane splitPane;
    private JList<String> listMenu;
    private JPanel contentPanel;
    private JButton button1;
    private JPanel mainPanel; // Panel chính để chứa contentPanel và buttonPanel

    public Review1(User user) {
        this.currentUser = user;
// ... phần còn lại của constructor ...
    }

    public Review1() {
// Tạo danh sách các mục cho menu
        String[] menuItems = {"Java Intro", "Java Syntax", "Java Output", "Java Comments", "Java Variables", "Java Data Types", "Java Type Casting", "Java Operators", "Java Strings", "Java Math", "Java Booleans", "Java If...Else", "Java Switch", "Java While Loop", "Java For Loop", "Java Break/Continue", "Java Arrays"};
        listMenu = new JList<>(menuItems);
        listMenu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listMenu.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    updateContentPanel(listMenu.getSelectedValue());
                }
            }
        });

// Tạo panel nội dung
        contentPanel = new JPanel(new CardLayout());

// Thêm các panel tạo từ createContent vào contentPanel
        for (String item : menuItems) {
            contentPanel.add(createContent(item), item);
        }

// Tạo nút
        button1 = new JButton("Back");

// Tạo panel chính và thêm contentPanel và button1 vào đó
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(contentPanel, BorderLayout.CENTER); // Thêm contentPanel vào giữa
        mainPanel.add(button1, BorderLayout.SOUTH); // Thêm button1 vào phía Nam

// Tạo split pane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(listMenu), mainPanel);
        splitPane.setDividerLocation(200); // Đặt vị trí divider cố định là 300 pixels

// Cấu hình cửa sổ
        setLayout(new BorderLayout());
        add(splitPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
// Đóng cửa sổ hiện tại (nếu cửa sổ này không cần thiết nữa)
                Review1.this.dispose();

// Tạo và hiển thị cửa sổ mới của lớp MenuExaminee
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        MenuExaminee menuExaminee = new MenuExaminee(currentUser); // Sử dụng đối tượng User hiện tại
                        menuExaminee.setVisible(true);
                    }
                });
            }
        });
    }

    private void updateContentPanel(String menuItem) {
        CardLayout cl = (CardLayout) (contentPanel.getLayout());
        cl.show(contentPanel, menuItem);
    }

    private JPanel createContent(String item) {
        JPanel panel = new JPanel(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        switch (item) {
            case "Java Intro":
                JLabel label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "h3 {color: #4682B4;}"
                        + "p {margin: 5px 5px;}"
                        + "ul {margin: 10px 0; padding-left: 20px;}"
                        + "li {margin: 5px 0;}"
                        + "</style>"
                        + "<h2>What is Java?</h2>"
                        + "<p>Java is a popular programming language, created in 1995.</p>"
                        + "<p>It is owned by Oracle, and more than 3 billion devices run Java.</p>"
                        + "<p>It is used for:</p>"
                        + "<ul>"
                        + "<li>Mobile applications (specially Android apps)</li>"
                        + "<li>Desktop applications</li>"
                        + "<li>Web applications</li>"
                        + "<li>Web servers and application servers</li>"
                        + "<li>Games</li>"
                        + "<li>Database connection</li>"
                        + "<li>And much, much more!</li>"
                        + "</ul>"
                        + "<h3>Why Use Java?</h3>"
                        + "<p>Java works on different platforms (Windows, Mac, Linux, Raspberry Pi, etc.)</p>"
                        + "<p>It is one of the most popular programming languages in the world</p>"
                        + "<p>It has a large demand in the current job market</p>"
                        + "<p>It is easy to learn and simple to use</p>"
                        + "<p>It is open-source and free</p>"
                        + "<p>It is secure, fast and powerful</p>"
                        + "<p>It has huge community support (tens of millions of developers)</p>"
                        + "<p>Java is an object oriented language which gives a clear structure to programs and allows code to be reused, lowering development costs</p>"
                        + "<p>As Java is close to C++ and C#, it makes it easy for programmers to switch to Java or vice versa.</p>"
                        + "</html>");
                scrollPane.getViewport().add(label);

                break;

            case "Java Syntax":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "h3 {color: #4682B4;}"
                        + "p {margin: 5px 0;}"
                        + "pre {background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd;}"
                        + "</style>"
                        + "<h2>Java Syntax</h2>"
                        + "<p>In the previous chapter, we created a Java file called <code>Main.java</code>, and we used the following code to print \"Hello World\" to the screen:</p>"
                        + "<h3>Main.java</h3>"
                        + "<pre>"
                        + "public class Main {<br>"
                        + "  public static void main(String[] args) {<br>"
                        + "    System.out.println(\"Hello World\");<br>"
                        + "  }<br>"
                        + "}</pre>"
                        + "<h3>Example explained</h3>"
                        + "<p>Every line of code that runs in Java must be inside a class. In our example, we named the class <code>Main</code>. A class should always start with an uppercase first letter.</p>"
                        + "<p><strong>Note:</strong> Java is case-sensitive: \"MyClass\" and \"myclass\" have different meanings.</p>"
                        + "<p>The name of the java file must match the class name. When saving the file, save it using the class name and add \".java\" to the end of the filename. To run the example above on your computer, make sure that Java is properly installed: Go to the Get Started Chapter for how to install Java. The output should be:</p>"
                        + "<pre>Hello World</pre>"
                        + "<h3>The main Method</h3>"
                        + "<p>The <code>main()</code> method is required and you will see it in every Java program:</p>"
                        + "<pre>public static void main(String[] args)</pre>"
                        + "<p>Any code inside the <code>main()</code> method will be executed. Don't worry about the keywords before and after <code>main</code>. You will get to know them bit by bit while reading this tutorial.</p>"
                        + "<p>For now, just remember that every Java program has a class name which must match the filename, and that every program must contain the <code>main()</code> method.</p>"
                        + "<h3>System.out.println()</h3>"
                        + "<p>Inside the <code>main()</code> method, we can use the <code>println()</code> method to print a line of text to the screen:</p>"
                        + "<pre>"
                        + "public static void main(String[] args) {<br>"
                        + "  System.out.println(\"Hello World\");<br>"
                        + "}</pre>"
                        + "<p><strong>Note:</strong> The curly braces {} mark the beginning and the end of a block of code.</p>"
                        + "<p><code>System</code> is a built-in Java class that contains useful members, such as <code>out</code>, which is short for \"output\". The <code>println()</code> method, short for \"print line\", is used to print a value to the screen (or a file).</p>"
                        + "<p>Don't worry too much about <code>System</code>, <code>out</code> and <code>println()</code>. Just know that you need them together to print stuff to the screen.</p>"
                        + "<p>You should also note that each code statement must end with a semicolon (;).</p>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại

            case "Java Output":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "h3 {color: #4682B4;}"
                        + "p {margin: 5px 0;}"
                        + "pre {background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd;}"
                        + "</style>"
                        + "<h2>Java Output</h2>"
                        + "<h3>Print Text</h3>"
                        + "<p>You learned from the previous chapter that you can use the <code>println()</code> method to output values or print text in Java:</p>"
                        + "<pre>System.out.println(\"Hello World!\");</pre>"
                        + "<p>You can add as many <code>println()</code> methods as you want. Note that it will add a new line for each method:</p>"
                        + "<pre>"
                        + "System.out.println(\"Hello World!\");<br>"
                        + "System.out.println(\"I am learning Java.\");<br>"
                        + "System.out.println(\"It is awesome!\");"
                        + "</pre>"
                        + "<h3>Double Quotes</h3>"
                        + "<p>When you are working with text, it must be wrapped inside double quotation marks \"\".</p>"
                        + "<p>If you forget the double quotes, an error occurs:</p>"
                        + "<pre>"
                        + "System.out.println(\"This sentence will work!\");<br>"
                        + "System.out.println(This sentence will produce an error);"
                        + "</pre>"
                        + "<h3>The Print() Method</h3>"
                        + "<p>There is also a <code>print()</code> method, which is similar to <code>println()</code>.</p>"
                        + "<p>The only difference is that it does not insert a new line at the end of the output:</p>"
                        + "<pre>"
                        + "System.out.print(\"Hello World! \");<br>"
                        + "System.out.print(\"I will print on the same line.\");"
                        + "</pre>"
                        + "<p>Note that we add an extra space (after \"Hello World!\" in the example above), for better readability.</p>"
                        + "<p>In this tutorial, we will only use <code>println()</code> as it makes it easier to read the output of code.</p>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại

            case "Java Comments":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "h3 {color: #4682B4;}"
                        + "p {margin: 5px 0;}"
                        + "pre {background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd;}"
                        + "</style>"
                        + "<h2>Java Comments</h2>"
                        + "<p>Comments can be used to explain Java code, and to make it more readable. It can also be used to prevent execution when testing alternative code.</p>"
                        + "<h3>Single-line Comments</h3>"
                        + "<p>Single-line comments start with two forward slashes (//).</p>"
                        + "<p>Any text between // and the end of the line is ignored by Java (will not be executed).</p>"
                        + "<p>This example uses a single-line comment before a line of code:</p>"
                        + "<pre>"
                        + "// This is a comment<br>"
                        + "System.out.println(\"Hello World\");<br>"
                        + "</pre>"
                        + "<p>This example uses a single-line comment at the end of a line of code:</p>"
                        + "<pre>"
                        + "System.out.println(\"Hello World\"); // This is a comment<br>"
                        + "</pre>"
                        + "<h3>Java Multi-line Comments</h3>"
                        + "<p>Multi-line comments start with /* and end with */.</p>"
                        + "<p>Any text between /* and */ will be ignored by Java.</p>"
                        + "<p>This example uses a multi-line comment (a comment block) to explain the code:</p>"
                        + "<pre>"
                        + "/* The code below will print the words Hello World<br>"
                        + "to the screen, and it is amazing */<br>"
                        + "System.out.println(\"Hello World\");<br>"
                        + "</pre>"
                        + "<h3>Single or multi-line comments?</h3>"
                        + "<p>It is up to you which you want to use. Normally, we use // for short comments, and /* */ for longer.</p>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại

            case "Java Variables":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "h3 {color: #4682B4;}"
                        + "p {margin: 5px 0;}"
                        + "pre {background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd;}"
                        + "</style>"
                        + "<h2>Java Variables</h2>"
                        + "<p>Variables are containers for storing data values.</p>"
                        + "<p>In Java, there are different types of variables, for example:</p>"
                        + "<ul>"
                        + "<li><code>String</code> - stores text, such as \"Hello\". String values are surrounded by double quotes</li>"
                        + "<li><code>int</code> - stores integers (whole numbers), without decimals, such as 123 or -123</li>"
                        + "<li><code>float</code> - stores floating point numbers, with decimals, such as 19.99 or -19.99</li>"
                        + "<li><code>char</code> - stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes</li>"
                        + "<li><code>boolean</code> - stores values with two states: true or false</li>"
                        + "</ul>"
                        + "<h3>Declaring (Creating) Variables</h3>"
                        + "<p>To create a variable, you must specify the type and assign it a value:</p>"
                        + "<pre>type variableName = value;</pre>"
                        + "<p>Where <code>type</code> is one of Java's types (such as <code>int</code> or <code>String</code>), and <code>variableName</code> is the name of the variable (such as <code>x</code> or <code>name</code>). The equal sign is used to assign values to the variable.</p>"
                        + "<p>To create a variable that should store text, look at the following example:</p>"
                        + "<pre>"
                        + "String name = \"John\";<br>"
                        + "System.out.println(name);"
                        + "</pre>"
                        + "<p>To create a variable that should store a number, look at the following example:</p>"
                        + "<pre>"
                        + "int myNum = 15;<br>"
                        + "System.out.println(myNum);"
                        + "</pre>"
                        + "<p>You can also declare a variable without assigning the value, and assign the value later:</p>"
                        + "<pre>"
                        + "int myNum;<br>"
                        + "myNum = 15;<br>"
                        + "System.out.println(myNum);"
                        + "</pre>"
                        + "<p>Note that if you assign a new value to an existing variable, it will overwrite the previous value:</p>"
                        + "<pre>"
                        + "int myNum = 15;<br>"
                        + "myNum = 20;  // myNum is now 20<br>"
                        + "System.out.println(myNum);"
                        + "</pre>"
                        + "<h3>Final Variables</h3>"
                        + "<p>If you don't want others (or yourself) to overwrite existing values, use the <code>final</code> keyword (this will declare the variable as \"final\" or \"constant\", which means unchangeable and read-only):</p>"
                        + "<pre>"
                        + "final int myNum = 15;<br>"
                        + "myNum = 20;  // will generate an error: cannot assign a value to a final variable"
                        + "</pre>"
                        + "<h3>Other Types</h3>"
                        + "<p>A demonstration of how to declare variables of other types:</p>"
                        + "<pre>"
                        + "int myNum = 5;<br>"
                        + "float myFloatNum = 5.99f;<br>"
                        + "char myLetter = 'D';<br>"
                        + "boolean myBool = true;<br>"
                        + "String myText = \"Hello\";"
                        + "</pre>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại

            case "Java Data Types":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "h3 {color: #4682B4;}"
                        + "p {margin: 5px 0;}"
                        + "pre {background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd;}"
                        + "table {border-collapse: collapse; width: 100%;}"
                        + "table, th, td {border: 1px solid black;}"
                        + "th, td {padding: 8px; text-align: left;}"
                        + "</style>"
                        + "<h2>Java Data Types</h2>"
                        + "<p>As explained in the previous chapter, a variable in Java must be a specified data type:</p>"
                        + "<pre>"
                        + "int myNum = 5;               // Integer (whole number)<br>"
                        + "float myFloatNum = 5.99f;    // Floating point number<br>"
                        + "char myLetter = 'D';         // Character<br>"
                        + "boolean myBool = true;       // Boolean<br>"
                        + "String myText = \"Hello\";     // String"
                        + "</pre>"
                        + "<p>Data types are divided into two groups:</p>"
                        + "<ul>"
                        + "<li>Primitive data types - includes byte, short, int, long, float, double, boolean and char</li>"
                        + "<li>Non-primitive data types - such as String, Arrays and Classes (you will learn more about these in a later chapter)</li>"
                        + "</ul>"
                        + "<h3>Primitive Data Types</h3>"
                        + "<p>A primitive data type specifies the size and type of variable values, and it has no additional methods.</p>"
                        + "<p>There are eight primitive data types in Java:</p>"
                        + "<table>"
                        + "<tr><th>Data Type</th><th>Size</th><th>Description</th></tr>"
                        + "<tr><td>byte</td><td>1 byte</td><td>Stores whole numbers from -128 to 127</td></tr>"
                        + "<tr><td>short</td><td>2 bytes</td><td>Stores whole numbers from -32,768 to 32,767</td></tr>"
                        + "<tr><td>int</td><td>4 bytes</td><td>Stores whole numbers from -2,147,483,648 to 2,147,483,647</td></tr>"
                        + "<tr><td>long</td><td>8 bytes</td><td>Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807</td></tr>"
                        + "<tr><td>float</td><td>4 bytes</td><td>Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits</td></tr>"
                        + "<tr><td>double</td><td>8 bytes</td><td>Stores fractional numbers. Sufficient for storing 15 decimal digits</td></tr>"
                        + "<tr><td>boolean</td><td>1 bit</td><td>Stores true or false values</td></tr>"
                        + "<tr><td>char</td><td>2 bytes</td><td>Stores a single character/letter or ASCII values</td></tr>"
                        + "</table>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại


            case "Java Type Casting":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "h3 {color: #4682B4;}"
                        + "p {margin: 5px 0;}"
                        + "pre {background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd;}"
                        + "</style>"
                        + "<h2>Java Type Casting</h2>"
                        + "<p>Type casting is when you assign a value of one primitive data type to another type.</p>"
                        + "<p>In Java, there are two types of casting:</p>"
                        + "<ul>"
                        + "<li>Widening Casting (automatically) - converting a smaller type to a larger type size</li>"
                        + "<li>Narrowing Casting (manually) - converting a larger type to a smaller size type</li>"
                        + "</ul>"
                        + "<h3>Widening Casting</h3>"
                        + "<p>Widening casting is done automatically when passing a smaller size type to a larger size type:</p>"
                        + "<pre>"
                        + "public class Main {<br>"
                        + "  public static void main(String[] args) {<br>"
                        + "    int myInt = 9;<br>"
                        + "    double myDouble = myInt; // Automatic casting: int to double<br>"
                        + "<br>"
                        + "    System.out.println(myInt);      // Outputs 9<br>"
                        + "    System.out.println(myDouble);   // Outputs 9.0<br>"
                        + "  }<br>"
                        + "}"
                        + "</pre>"
                        + "<h3>Narrowing Casting</h3>"
                        + "<p>Narrowing casting must be done manually by placing the type in parentheses () in front of the value:</p>"
                        + "<pre>"
                        + "public class Main {<br>"
                        + "  public static void main(String[] args) {<br>"
                        + "    double myDouble = 9.78d;<br>"
                        + "    int myInt = (int) myDouble; // Manual casting: double to int<br>"
                        + "<br>"
                        + "    System.out.println(myDouble);   // Outputs 9.78<br>"
                        + "    System.out.println(myInt);      // Outputs 9<br>"
                        + "  }<br>"
                        + "}"
                        + "</pre>"
                        + "<h3>Real-Life Example</h3>"
                        + "<p>Here's a real-life example of type casting where we create a program to calculate the percentage of a user's score in relation to the maximum score in a game.</p>"
                        + "<p>We use type casting to make sure that the result is a floating-point value, rather than an integer:</p>"
                        + "<pre>"
                        + "// Set the maximum possible score in the game to 500<br>"
                        + "int maxScore = 500;<br>"
                        + "<br>"
                        + "// The actual score of the user<br>"
                        + "int userScore = 423;<br>"
                        + "<br>"
                        + "/* Calculate the percantage of the user's score in relation to the maximum available score.<br>"
                        + "Convert userScore to float to make sure that the division is accurate */<br>"
                        + "float percentage = (float) userScore / maxScore * 100.0f;<br>"
                        + "<br>"
                        + "System.out.println(\"User's percentage is \" + percentage);"
                        + "</pre>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại
            case "Java Operators":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "h3 {color: #4682B4;}"
                        + "p {margin: 5px 0;}"
                        + "</style>"
                        + "<h2>Java Operators</h2>"
                        + "<p>Operators are used to perform operations on variables and values.</p>"
                        + "<p>In the example below, we use the + operator to add together two values:</p>"
                        + "<pre>"
                        + "int x = 100 + 50;"
                        + "</pre>"
                        + "<p>Although the + operator is often used to add together two values, like in the example above, it can also be used to add together a variable and a value, or a variable and another variable:</p>"
                        + "<pre>"
                        + "int sum1 = 100 + 50;        // 150 (100 + 50)<br>"
                        + "int sum2 = sum1 + 250;      // 400 (150 + 250)<br>"
                        + "int sum3 = sum2 + sum2;     // 800 (400 + 400)"
                        + "</pre>"
                        + "<p>Java divides the operators into the following groups:</p>"
                        + "<ul>"
                        + "<li>Arithmetic operators</li>"
                        + "<li>Assignment operators</li>"
                        + "<li>Comparison operators</li>"
                        + "<li>Logical operators</li>"
                        + "<li>Bitwise operators</li>"
                        + "</ul>"
                        + "<h3>Arithmetic Operators</h3>"
                        + "<p>Arithmetic operators are used to perform common mathematical operations.</p>"
                        + "<h3>Java Assignment Operators</h3>"
                        + "<p>Assignment operators are used to assign values to variables.</p>"
                        + "<h3>Java Comparison Operators</h3>"
                        + "<p>Comparison operators are used to compare two values (or variables).</p>"
                        + "<h3>Java Logical Operators</h3>"
                        + "<p>You can also test for true or false values with logical operators.</p>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại

            case "Java Strings":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "h3 {color: #4682B4;}"
                        + "p {margin: 5px 0;}"
                        + "</style>"
                        + "<h2>Java Strings</h2>"
                        + "<p>Strings are used for storing text.</p>"
                        + "<p>A String variable contains a collection of characters surrounded by double quotes:</p>"
                        + "<pre>"
                        + "String greeting = \"Hello\";"
                        + "</pre>"
                        + "<h3>String Length</h3>"
                        + "<p>A String in Java is actually an object, which contain methods that can perform certain operations on strings. For example, the length of a string can be found with the length() method:</p>"
                        + "<pre>"
                        + "String txt = \"ABCDEFGHIJKLMNOPQRSTUVWXYZ\";<br>"
                        + "System.out.println(\"The length of the txt string is: \" + txt.length());"
                        + "</pre>"
                        + "<h3>More String Methods</h3>"
                        + "<p>There are many string methods available, for example toUpperCase() and toLowerCase():</p>"
                        + "<pre>"
                        + "String txt = \"Hello World\";<br>"
                        + "System.out.println(txt.toUpperCase());   // Outputs \"HELLO WORLD\"<br>"
                        + "System.out.println(txt.toLowerCase());   // Outputs \"hello world\""
                        + "</pre>"
                        + "<h3>Finding a Character in a String</h3>"
                        + "<p>The indexOf() method returns the index (the position) of the first occurrence of a specified text in a string (including whitespace):</p>"
                        + "<pre>"
                        + "String txt = \"Please locate where 'locate' occurs!\";<br>"
                        + "System.out.println(txt.indexOf(\"locate\")); // Outputs 7"
                        + "</pre>"
                        + "<p>Java counts positions from zero.<br>"
                        + "0 is the first position in a string, 1 is the second, 2 is the third ...</p>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại
            case "Java Math":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "h3 {color: #4682B4;}"
                        + "p {margin: 5px 0;}"
                        + "</style>"
                        + "<h2>Java Math</h2>"
                        + "<p>The Java Math class has many methods that allow you to perform mathematical tasks on numbers.</p>"
                        + "<h3>Math.max(x, y)</h3>"
                        + "<p>The Math.max(x, y) method can be used to find the highest value of x and y:</p>"
                        + "<pre>"
                        + "Math.max(5, 10);"
                        + "</pre>"
                        + "<h3>Math.min(x, y)</h3>"
                        + "<p>The Math.min(x, y) method can be used to find the lowest value of x and y:</p>"
                        + "<pre>"
                        + "Math.min(5, 10);"
                        + "</pre>"
                        + "<h3>Math.sqrt(x)</h3>"
                        + "<p>The Math.sqrt(x) method returns the square root of x:</p>"
                        + "<pre>"
                        + "Math.sqrt(64);"
                        + "</pre>"
                        + "<h3>Math.abs(x)</h3>"
                        + "<p>The Math.abs(x) method returns the absolute (positive) value of x:</p>"
                        + "<pre>"
                        + "Math.abs(-4.7);"
                        + "</pre>"
                        + "<h3>Random Numbers</h3>"
                        + "<p>Math.random() returns a random number between 0.0 (inclusive), and 1.0 (exclusive):</p>"
                        + "<pre>"
                        + "Math.random();"
                        + "</pre>"
                        + "<p>To get more control over the random number, for example, if you only want a random number between 0 and 100, you can use the following formula:</p>"
                        + "<pre>"
                        + "int randomNum = (int)(Math.random() * 101);  // 0 to 100"
                        + "</pre>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại
            case "Java Booleans":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "h3 {color: #4682B4;}"
                        + "p {margin: 5px 0;}"
                        + "</style>"
                        + "<h2>Java Booleans</h2>"
                        + "<p>Very often, in programming, you will need a data type that can only have one of two values, like:</p>"
                        + "<ul>"
                        + "<li>YES / NO</li>"
                        + "<li>ON / OFF</li>"
                        + "<li>TRUE / FALSE</li>"
                        + "</ul>"
                        + "<p>For this, Java has a boolean data type, which can store true or false values.</p>"
                        + "<h3>Boolean Values</h3>"
                        + "<p>A boolean type is declared with the boolean keyword and can only take the values true or false:</p>"
                        + "<pre>"
                        + "boolean isJavaFun = true;<br>"
                        + "boolean isFishTasty = false;<br>"
                        + "System.out.println(isJavaFun);     // Outputs true<br>"
                        + "System.out.println(isFishTasty);   // Outputs false"
                        + "</pre>"
                        + "<p>However, it is more common to return boolean values from boolean expressions, for conditional testing.</p>"
                        + "<h3>Boolean Expression</h3>"
                        + "<p>A Boolean expression returns a boolean value: true or false. This is useful to build logic, and find answers.</p>"
                        + "<p>For example, you can use a comparison operator, such as the greater than (>) operator, to find out if an expression (or a variable) is true or false:</p>"
                        + "<pre>"
                        + "int x = 10;<br>"
                        + "int y = 9;<br>"
                        + "System.out.println(x > y); // returns true, because 10 is higher than 9"
                        + "</pre>"
                        + "<p>Or even easier:</p>"
                        + "<pre>"
                        + "System.out.println(10 > 9); // returns true, because 10 is higher than 9"
                        + "</pre>"
                        + "<p>In the examples below, we use the equal to (==) operator to evaluate an expression:</p>"
                        + "<pre>"
                        + "int x = 10;<br>"
                        + "System.out.println(x == 10); // returns true, because the value of x is equal to 10<br>"
                        + "System.out.println(10 == 15); // returns false, because 10 is not equal to 15"
                        + "</pre>"
                        + "<h3>Real Life Example</h3>"
                        + "<p>Let's think of a \"real life example\" where we need to find out if a person is old enough to vote.</p>"
                        + "<p>In the example below, we use the >= comparison operator to find out if the age (25) is greater than OR equal to the voting age limit, which is set to 18:</p>"
                        + "<pre>"
                        + "int myAge = 25;<br>"
                        + "int votingAge = 18;<br>"
                        + "System.out.println(myAge >= votingAge);"
                        + "</pre>"
                        + "<p>An even better approach would be to wrap the code above in an if...else statement, so we can perform different actions depending on the result:</p>"
                        + "<pre>"
                        + "int myAge = 25;<br>"
                        + "int votingAge = 18;<br>"
                        + "if (myAge >= votingAge) {<br>"
                        + "  System.out.println(\"Old enough to vote!\");<br>"
                        + "} else {<br>"
                        + "  System.out.println(\"Not old enough to vote.\");<br>"
                        + "}"
                        + "</pre>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại


            case "Java If...Else":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "h3 {color: #4682B4;}"
                        + "p {margin: 5px 0;}"
                        + "pre {background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd;}"
                        + "</style>"
                        + "<h2>Java Conditions and If Statements</h2>"
                        + "<p>You already know that Java supports the usual logical conditions from mathematics:</p>"
                        + "<ul>"
                        + "<li>Less than: a &lt; b</li>"
                        + "<li>Less than or equal to: a &lt;= b</li>"
                        + "<li>Greater than: a &gt; b</li>"
                        + "<li>Greater than or equal to: a &gt;= b</li>"
                        + "<li>Equal to: a == b</li>"
                        + "<li>Not Equal to: a != b</li>"
                        + "</ul>"
                        + "<p>You can use these conditions to perform different actions for different decisions.</p>"
                        + "<p>Java has the following conditional statements:</p>"
                        + "<ul>"
                        + "<li>Use if to specify a block of code to be executed, if a specified condition is true</li>"
                        + "<li>Use else to specify a block of code to be executed, if the same condition is false</li>"
                        + "<li>Use else if to specify a new condition to test, if the first condition is false</li>"
                        + "<li>Use switch to specify many alternative blocks of code to be executed</li>"
                        + "</ul>"
                        + "<h3>The if Statement</h3>"
                        + "<p>Use the if statement to specify a block of Java code to be executed if a condition is true.</p>"
                        + "<p>Note that if is in lowercase letters. Uppercase letters (If or IF) will generate an error.</p>"
                        + "<p>In the example below, we test two values to find out if 20 is greater than 18. If the condition is true, print some text:</p>"
                        + "<pre>"
                        + "if (20 &gt; 18) {<br>"
                        + "  System.out.println(\"20 is greater than 18\");<br>"
                        + "}"
                        + "</pre>"
                        + "<p>We can also test variables:</p>"
                        + "<pre>"
                        + "int x = 20;<br>"
                        + "int y = 18;<br>"
                        + "if (x &gt; y) {<br>"
                        + "  System.out.println(\"x is greater than y\");<br>"
                        + "}"
                        + "</pre>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại

            case "Java Switch":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "h3 {color: #4682B4;}"
                        + "p {margin: 5px 0;}"
                        + "pre {background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd;}"
                        + "</style>"
                        + "<h2>Java Switch Statements</h2>"
                        + "<p>Instead of writing many if..else statements, you can use the switch statement.</p>"
                        + "<p>The switch statement selects one of many code blocks to be executed:</p>"
                        + "<pre>"
                        + "switch(expression) {<br>"
                        + "  case x:<br>"
                        + "    // code block<br>"
                        + "    break;<br>"
                        + "  case y:<br>"
                        + "    // code block<br>"
                        + "    break;<br>"
                        + "  default:<br>"
                        + "    // code block<br>"
                        + "}"
                        + "</pre>"
                        + "<p>This is how it works:</p>"
                        + "<ul>"
                        + "<li>The switch expression is evaluated once.</li>"
                        + "<li>The value of the expression is compared with the values of each case.</li>"
                        + "<li>If there is a match, the associated block of code is executed.</li>"
                        + "<li>The break and default keywords are optional, and will be described later in this chapter.</li>"
                        + "</ul>"
                        + "<p>The example below uses the weekday number to calculate the weekday name:</p>"
                        + "<pre>"
                        + "int day = 4;<br>"
                        + "switch (day) {<br>"
                        + "  case 1:<br>"
                        + "    System.out.println(\"Monday\");<br>"
                        + "    break;<br>"
                        + "  case 2:<br>"
                        + "    System.out.println(\"Tuesday\");<br>"
                        + "    break;<br>"
                        + "  case 3:<br>"
                        + "    System.out.println(\"Wednesday\");<br>"
                        + "    break;<br>"
                        + "  case 4:<br>"
                        + "    System.out.println(\"Thursday\");<br>"
                        + "    break;<br>"
                        + "  case 5:<br>"
                        + "    System.out.println(\"Friday\");<br>"
                        + "    break;<br>"
                        + "  case 6:<br>"
                        + "    System.out.println(\"Saturday\");<br>"
                        + "    break;<br>"
                        + "  case 7:<br>"
                        + "    System.out.println(\"Sunday\");<br>"
                        + "    break;<br>"
                        + "}"
                        + "// Outputs \"Thursday\" (day 4)"
                        + "</pre>"
                        + "<p><strong>The break Keyword</strong></p>"
                        + "<p>When Java reaches a break keyword, it breaks out of the switch block.</p>"
                        + "<p>This will stop the execution of more code and case testing inside the block.</p>"
                        + "<p>When a match is found, and the job is done, it's time for a break. There is no need for more testing.</p>"
                        + "<p>A break can save a lot of execution time because it \"ignores\" the execution of all the rest of the code in the switch block.</p>"
                        + "<p><strong>The default Keyword</strong></p>"
                        + "<p>The default keyword specifies some code to run if there is no case match:</p>"
                        + "<pre>"
                        + "int day = 4;<br>"
                        + "switch (day) {<br>"
                        + "  case 6:<br>"
                        + "    System.out.println(\"Today is Saturday\");<br>"
                        + "    break;<br>"
                        + "  case 7:<br>"
                        + "    System.out.println(\"Today is Sunday\");<br>"
                        + "    break;<br>"
                        + "  default:<br>"
                        + "    System.out.println(\"Looking forward to the Weekend\");<br>"
                        + "}"
                        + "// Outputs \"Looking forward to the Weekend\""
                        + "</pre>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại

            case "Java While Loop":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "p {margin: 5px 0;}"
                        + "pre {background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd;}"
                        + "</style>"
                        + "<h2>Java While Loop</h2>"
                        + "<p>The while loop loops through a block of code as long as a specified condition is true:</p>"
                        + "<pre>"
                        + "while (condition) {<br>"
                        + "  // code block to be executed<br>"
                        + "}"
                        + "</pre>"
                        + "<p>In the example below, the code in the loop will run, over and over again, as long as a variable (i) is less than 5:</p>"
                        + "<pre>"
                        + "int i = 0;<br>"
                        + "while (i < 5) {<br>"
                        + "  System.out.println(i);<br>"
                        + "  i++;<br>"
                        + "}"
                        + "</pre>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại

            case "Java For Loop":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "p {margin: 5px 0;}"
                        + "pre {background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd;}"
                        + "</style>"
                        + "<h2>Java For Loop</h2>"
                        + "<p>When you know exactly how many times you want to loop through a block of code, use the for loop instead of a while loop:</p>"
                        + "<pre>"
                        + "for (statement 1; statement 2; statement 3) {<br>"
                        + "  // code block to be executed<br>"
                        + "}"
                        + "</pre>"
                        + "<p>The example below will print the numbers 0 to 4:</p>"
                        + "<pre>"
                        + "for (int i = 0; i < 5; i++) {<br>"
                        + "  System.out.println(i);<br>"
                        + "}"
                        + "</pre>"
                        + "<p>Another Example:</p>"
                        + "<p>This example will only print even values between 0 and 10:</p>"
                        + "<pre>"
                        + "for (int i = 0; i <= 10; i = i + 2) {<br>"
                        + "  System.out.println(i);<br>"
                        + "}"
                        + "</pre>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại


            case "Java Break and Continue":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "p {margin: 5px 0;}"
                        + "pre {background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd;}"
                        + "</style>"
                        + "<h2>Java Break and Continue</h2>"
                        + "<p>You have already seen the break statement used in an earlier chapter of this tutorial. It was used to \"jump out\" of a switch statement.</p>"
                        + "<p>The break statement can also be used to jump out of a loop.</p>"
                        + "<p>This example stops the loop when i is equal to 4:</p>"
                        + "<pre>"
                        + "for (int i = 0; i < 10; i++) {<br>"
                        + "  if (i == 4) {<br>"
                        + "    break;<br>"
                        + "  }<br>"
                        + "  System.out.println(i);<br>"
                        + "}"
                        + "</pre>"
                        + "<p>Java Continue</p>"
                        + "<p>The continue statement breaks one iteration (in the loop), if a specified condition occurs, and continues with the next iteration in the loop.</p>"
                        + "<p>This example skips the value of 4:</p>"
                        + "<pre>"
                        + "for (int i = 0; i < 10; i++) {<br>"
                        + "  if (i == 4) {<br>"
                        + "    continue;<br>"
                        + "  }<br>"
                        + "  System.out.println(i);<br>"
                        + "}"
                        + "</pre>"
                        + "<p>Break and Continue in While Loop</p>"
                        + "<p>You can also use break and continue in while loops:</p>"
                        + "<p>Break Example</p>"
                        + "<pre>"
                        + "int i = 0;<br>"
                        + "while (i < 10) {<br>"
                        + "  System.out.println(i);<br>"
                        + "  i++;<br>"
                        + "  if (i == 4) {<br>"
                        + "    break;<br>"
                        + "  }<br>"
                        + "}"
                        + "</pre>"
                        + "<p>Continue Example</p>"
                        + "<pre>"
                        + "int i = 0;<br>"
                        + "while (i < 10) {<br>"
                        + "  if (i == 4) {<br>"
                        + "    i++;<br>"
                        + "    continue;<br>"
                        + "  }<br>"
                        + "  System.out.println(i);<br>"
                        + "  i++;<br>"
                        + "}"
                        + "</pre>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại

            case "Java Arrays":
                label = new JLabel("<html>"
                        + "<style>"
                        + "h2 {color: #2E8B57;}"
                        + "p {margin: 5px 0;}"
                        + "pre {background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd;}"
                        + "</style>"
                        + "<h2>Java Arrays</h2>"
                        + "<p>Arrays are used to store multiple values in a single variable, instead of declaring separate variables for each value.</p>"
                        + "<p>To declare an array, define the variable type with square brackets:</p>"
                        + "<pre>String[] cars;</pre>"
                        + "<p>We have now declared a variable that holds an array of strings. To insert values to it, you can place the values in a comma-separated list, inside curly braces:</p>"
                        + "<pre>String[] cars = {\"Volvo\", \"BMW\", \"Ford\", \"Mazda\"};</pre>"
                        + "<p>To create an array of integers, you could write:</p>"
                        + "<pre>int[] myNum = {10, 20, 30, 40};</pre>"
                        + "<p>Access the Elements of an Array</p>"
                        + "<p>You can access an array element by referring to the index number.</p>"
                        + "<p>This statement accesses the value of the first element in cars:</p>"
                        + "<pre>String[] cars = {\"Volvo\", \"BMW\", \"Ford\", \"Mazda\"};<br>"
                        + "System.out.println(cars[0]);<br>"
                        + "// Outputs Volvo</pre>"
                        + "<p>Note: Array indexes start with 0: [0] is the first element. [1] is the second element, etc.</p>"
                        + "<p>Change an Array Element</p>"
                        + "<p>To change the value of a specific element, refer to the index number:</p>"
                        + "<pre>cars[0] = \"Opel\";</pre>"
                        + "<p>Example</p>"
                        + "<pre>String[] cars = {\"Volvo\", \"BMW\", \"Ford\", \"Mazda\"};<br>"
                        + "cars[0] = \"Opel\";<br>"
                        + "System.out.println(cars[0]);<br>"
                        + "// Now outputs Opel instead of Volvo</pre>"
                        + "<p>Array Length</p>"
                        + "<p>To find out how many elements an array has, use the length property:</p>"
                        + "<pre>String[] cars = {\"Volvo\", \"BMW\", \"Ford\", \"Mazda\"};<br>"
                        + "System.out.println(cars.length);<br>"
                        + "// Outputs 4</pre>"
                        + "</html>");
                scrollPane.getViewport().add(label);
                break;
// Thêm các case khác cho các mục còn lại


            default:
                panel.add(new JLabel("Nội dung mặc định"), BorderLayout.CENTER);
                break;
        }
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Review1().setVisible(true));
    }
}