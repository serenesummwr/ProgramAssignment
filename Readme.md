# CSV Student Sorter

A Java program that reads student records from a CSV file and provides various sorting and searching functionalities using QuickSort algorithm.

## Features

- Sort students by:
  - Student ID
  - First Name
  - Last Name
- Search for students by first name
- Custom QuickSort implementation for efficient sorting
- CSV file handling with error management

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- CSV file containing student records with course information and student data

## Installation

1. Clone or download the source code
2. Compile the Java files:
```bash
javac CSVSorter.java
```

## Usage

The program accepts command-line arguments in the following format:
```bash
java CSVSorter [option] [file_path] [search_name]
```

### Command Options

- `-n`: Sort by Student ID
- `-f`: Sort by First Name
- `-l`: Sort by Last Name
- `-s`: Search by First Name (requires an additional search_name parameter)

### Examples

Sort by Student ID:
```bash
java CSVSorter -n "/Users/natthapoom/Desktop/ProgramAssignment/Class Roaster 953102 Problem Solving Lec 701.csv"
```

Sort by First Name:
```bash
java CSVSorter -f "/Users/natthapoom/Desktop/ProgramAssignment/Class Roaster 953102 Problem Solving Lec 701.csv"
```

Sort by Last Name:
```bash
java CSVSorter -l "/Users/natthapoom/Desktop/ProgramAssignment/Class Roaster 953102 Problem Solving Lec 701.csv"
```

Search for a student by first name:
```bash
java CSVSorter -s "/Users/natthapoom/Desktop/ProgramAssignment/Class Roaster 953102 Problem Solving Lec 701.csv" Natthapoom
```

Note: If your file path contains spaces, make sure to enclose it in quotes as shown in the examples above.

## Input File Format

The program is designed to work with the CMU course roster CSV format. The file structure is as follows:

```csv
รายชื่อนักศึกษาที่ลงทะเบียนเรียน ภาคเรียนที่ 2 ปีการศึกษา 2567,,,,,,,,,
COURSE NO :,,953102,...
TITLE :,,Abstract Data Type and Problem Solving,,,,,,,
SECTION (lec/lab) :,,701 / 000,,,,,,,
...
ที่,รหัสนักศึกษา,ชื่อ - นามสกุล,,1,2,3,4,5,6
1,672115011,NATTHAPOOM ,SAENGKAEW,,,,,,
```

Key format details:
- The student data starts after the header rows
- Column 2: Student ID (รหัสนักศึกษา)
- Column 3: Full name (ชื่อ - นามสกุล) split into first and last names
- The program specifically processes students with IDs containing "2115"

## Implementation Details

- Uses QuickSort algorithm with the following complexity:
  - Time Complexity: O(n log n) average case
  - Space Complexity: O(log n)
- In-place sorting implementation
- Case-insensitive search functionality
- Vector data structure for student records
- Handles Thai language CSV headers and content

## Error Handling

The program includes error handling for:
- Missing command-line arguments
- File not found exceptions
- Invalid command options
- Missing search parameter
- Invalid CSV format
- Incomplete student records

## Contributing

Feel free to fork the repository and submit pull requests for any improvements.

## License

This project is open source and available under the MIT License.
