<h1 align="center">
Simple Java Text Editor
</h1>

<p align="center">

<img src="https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white">
<img src="https://img.shields.io/badge/Java%20Swing-GUI-blue">
<img src="https://img.shields.io/badge/OOP-Object%20Oriented%20Programming-green">
<img src="https://img.shields.io/badge/File%20Handling-Java-orange">
<img src="https://img.shields.io/badge/Event%20Handling-Swing-purple">

</p>

<p align="center">
A lightweight **Java Swing text editor** developed as part of an academic project.
</p>

## Course

Object Oriented Methodology (OOM)

## Features

- Create, open, and save text files
- Text formatting (Bold, Italic, Underline)
- Text alignment (Left, Right, Center, Justified)
- Clipboard operations (Cut, Copy, Paste)
- Light and Dark themes
- Keyboard shortcuts
- File chooser integration

## Technologies Used

- Java
- Java Swing
- Event Handling
- File I/O

## Application Flow

```mermaid
flowchart TD

A[Start Application] --> B[Launch JFrame Window]

B --> C[Display Text Editor Interface]

C --> D[User Interaction]

D --> E1[File Menu]
D --> E2[Edit Menu]
D --> E3[Format Menu]
D --> E4[Theme Menu]
D --> E5[Help Menu]

E1 --> F1[New File]
E1 --> F2[Open File]
E1 --> F3[Save File]
E1 --> F4[Exit]

F2 --> G1[Open File Chooser]
F3 --> G2[Save File Chooser]

E2 --> H1[Cut]
E2 --> H2[Copy]
E2 --> H3[Paste]
E2 --> H4[Select All]

E3 --> I1[Bold]
E3 --> I2[Italic]
E3 --> I3[Underline]

E3 --> J[Text Alignment]

J --> J1[Left]
J --> J2[Center]
J --> J3[Right]
J --> J4[Justified]

E4 --> K1[Light Theme]
E4 --> K2[Dark Theme]

E5 --> L[About Dialog]

L --> M[Display Project Info]
```

## How to Run

Compile:
javac SimpleTextEditor.java

Run:
java SimpleTextEditor


## Authors

| Name | Role |
|-----|-----|
Aashi Tiwari | Development |
Danny Thomas | Development |

This project was developed collaboratively as part of an **academic team project**.

---

© 2026 Aashi Tiwari

This repository is maintained by **Aashi Tiwari**.
