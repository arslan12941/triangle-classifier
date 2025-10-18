
## Task Description (7 Marks)
Create a GitHub account & repository (public). Add a README and upload the triangle classification code (in any language).  
Then:
1. Create a local directory and apply changes to the code file; use `git commit` to check changes made.  
2. Explain how bugs will be reported in GitHub and apply debugging techniques.

---

## 1. GitHub Account
1. Go to [https://github.com](https://github.com) and sign up using your email.  
2. Verify your email address to activate the account.  
3. Sign in to GitHub to create repositories and manage code.

---

## 2. Creating Repository
1. Click **New repository** on GitHub.  
2. Repository name: `triangle-classifier` (suggested).  
3. Add a short description: `Triangle classification program — Assignment 2`.  
4. Set visibility **Public**.  
5. Check **Initialize this repository with a README** (optional if you will upload your own).  
6. Click **Create repository**.

---

## 3. Clone Repository (Local Setup)
```bash
git clone https://github.com/<your-username>/triangle-classifier.git
cd triangle-classifier
```

---

## 4. Stage, Commit & Push
```bash
git add src/TriangleClassifier.java
git add README.md
git commit -m "Initial commit: Added triangle classification program"
git push origin main
```

---

## 5. Triangle Classification Program (Overview)
**Program Purpose:**  
Take three side lengths as input and print the type of triangle. The program validates the inputs and classifies the triangle by **side lengths** and **angles**.

**Classification Rules**
- Equilateral → all sides equal
- Isosceles → two sides equal
- Scalene → all sides different
- Acute, Right or Obtuse angle classification using Pythagorean theorem

---

## 6. Java Code — `TriangleClassifier.java`
```java
import java.util.Arrays;
import java.util.Scanner;

public class TriangleClassifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter three sides of the triangle:");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        sc.close();

        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Invalid input: All sides must be positive.");
            return;
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Invalid triangle: Triangle inequality violated.");
            return;
        }

        double[] sides = {a, b, c};
        Arrays.sort(sides);
        a = sides[0];
        b = sides[1];
        c = sides[2];

        String sideType;
        if (a == b && b == c) {
            sideType = "Equilateral Triangle";
        } else if (a == b || b == c || a == c) {
            sideType = "Isosceles Triangle";
        } else {
            sideType = "Scalene Triangle";
        }

        double lhs = a * a + b * b;
        double rhs = c * c;
        String angleType;
        if (Math.abs(lhs - rhs) < 1e-9) {
            angleType = "Right-angled Triangle";
        } else if (lhs > rhs) {
            angleType = "Acute Triangle";
        } else {
            angleType = "Obtuse Triangle";
        }

        System.out.println("Triangle Type: " + sideType + " and " + angleType);
    }
}
```

---

## 7. Bug Reporting Using GitHub Issues
1. Go to **Issues** → **New issue**.  
2. Fill out the issue template:

```
Title: Program accepts zero-length side without proper error handling

Steps to Reproduce:
1. Run the program
2. Input: 0 5 5

Expected Result:
"Invalid input: All sides must be positive."

Actual Result:
[describe incorrect behavior]

Severity: High
```

---

## 8. Committing Bug Fixes
```bash
git checkout -b fix/input-validation
git add src/TriangleClassifier.java
git commit -m "Fix #1: Added validation for zero and negative sides"
git push origin fix/input-validation
```

---

## 9. Debugging the Triangle Program
**Steps:**
- Set breakpoints at validation and classification points.  
- Step through code using debugger.  
- Check variables `a`, `b`, `c`, `lhs`, `rhs`.  
- Verify classification logic for edge cases.  
- Use `System.out.println` for manual debugging if needed.

---

## 10. Git Commands Used

| Command | Description |
|---------|-------------|
| `git init` | Initialize local repository |
| `git clone` | Clone remote repository |
| `git add` | Stage files |
| `git commit -m` | Commit staged files |
| `git push` | Push to GitHub |
| `git pull` | Pull from GitHub |
| `git status` | Check repository status |
| `git log` | View commit history |

---


✅ **End of README.md**
