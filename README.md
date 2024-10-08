# 🔐 Password Generator Project

A Java console application that generates secure passwords and checks password strength. The application provides a user-friendly interface for creating custom passwords with various character combinations and evaluating existing passwords.

## 🎯 Features

- ✨ Interactive password generation
- 🔍 Password strength checking
- 📊 Score-based password evaluation
- 💡 Password security tips
- 🎛️ Customizable character sets

## 🗂️ Project Structure

The project consists of four main Java classes:

### 1. Main.java
```java
public class Main {
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Generator generator = new Generator(input);
        generator.mainLoop();
        input.close();
    }
}
```
- Entry point of the application
- Initializes the Scanner for user input
- Creates Generator instance and starts main program loop

### 2. Generator.java
- Core functionality class that:
  - Handles user interface and menu system
  - Processes user input for password requirements
  - Generates passwords based on selected criteria
  - Provides password strength checking
  - Displays useful password security information

### 3. Password.java
- Password object class that:
  - Evaluates password strength using a scoring system
  - Checks for various character types (uppercase, lowercase, numbers, symbols)
  - Provides detailed password strength feedback
  - Calculates overall password score

### 4. Alphabet.java
- Character pool management class with:
  - Predefined character sets (uppercase, lowercase, numbers, symbols)
  - Dynamic pool generation based on user preferences
  - Flexible character set combinations

## 🛠️ Features Details

### Password Generation Options
- Lowercase letters (a-z)
- Uppercase letters (A-Z)
- Numbers (0-9)
- Special symbols (!@^[;:)-_+=|/<&*(#$%>{?,~)
- Customizable password length

### Password Strength Criteria
Score is calculated based on:
- Length (8-15 chars: +1 point, 16+ chars: +2 points)
- Character type usage:
  - Uppercase letters (+1)
  - Lowercase letters (+1)
  - Numbers (+1)
  - Symbols (+1)

### Strength Categories
- Very Strong: Score ≥ 16
- Strong: Score 8-15
- Good: Score 6-7
- Weak: Score 4-5
- Very Weak: Score < 4

## 💻 Usage

1. Run the program
2. Choose from the main menu:
   ```
   Enter 1 - Password Generator
   Enter 2 - Password Strength Checking
   Enter 3 - Useful Information
   Enter 4 - Quit
   ```

### Generate Password
1. Answer Y/N for each character type:
   - Lowercase letters
   - Uppercase letters
   - Numbers
   - Symbols
2. Enter desired password length
3. Receive generated password

### Check Password Strength
1. Enter existing password
2. View strength rating and score

## 📝 Building and Running

1. Compile all Java files:
```bash
javac Main.java Generator.java Password.java Alphabet.java
```

2. Run the application:
```bash
java Main
```

## 🔜 Potential Enhancements

- [ ] GUI interface
- [ ] Password storage functionality
- [ ] More complex password strength algorithms
- [ ] Password generation history
- [ ] Export password lists
- [ ] Custom symbol sets
- [ ] Password entropy calculation

## 👥 Contributing

Feel free to contribute to this project by:
1. Forking the repository
2. Creating your feature branch
3. Committing your changes
4. Pushing to the branch
5. Creating a new Pull Request
