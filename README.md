# Employee Management System (EMS)

A user-friendly and efficient Java-based solution designed to help small and medium-sized businesses manage their employee records with ease. The system uses HTML-based file storage for maintaining employee records in a neat and organized way.

## 🌟 Features

- **User Authentication**
  - Registration and login functionality
  - Secure credential storage in text file

- **Employee Management**
  - Add new employees with comprehensive details
  - View employee information through HTML files
  - Update existing employee records
  - Remove employee records
  - Emergency contact management
  - Salary calculation and management

- **Data Validation**
  - Email format validation using regex
  - Contact number format validation (9 digits)
  - Required field validation
  - Salary validation

## 🏗️ Architecture

### Core Classes Hierarchy
```
Person <<Abstract>>
├── User
├── EmployDetail
└── EmergencyContact
```

![class-hierarchy](https://github.com/user-attachments/assets/9c7de4fe-d525-48fe-9dbf-81a8bc4f356f)

![Uploading cl<svg viewBox="0 0 600 400" xmlns="http://www.w3.org/2000/svg">
  <!-- Abstract Person Class -->
  <rect x="240" y="20" width="120" height="50" fill="#e6e6e6" stroke="#333" rx="5"/>
  <text x="300" y="45" text-anchor="middle" font-family="Arial" font-size="14">Person</text>
  <text x="300" y="60" text-anchor="middle" font-family="Arial" font-size="12" font-style="italic">&lt;&lt;Abstract&gt;&gt;</text>
  
  <!-- Child Classes -->
  <rect x="80" y="150" width="120" height="40" fill="#fff" stroke="#333" rx="5"/>
  <text x="140" y="175" text-anchor="middle" font-family="Arial" font-size="14">User</text>
  
  <rect x="240" y="150" width="120" height="40" fill="#fff" stroke="#333" rx="5"/>
  <text x="300" y="175" text-anchor="middle" font-family="Arial" font-size="14">EmployDetail</text>
  
  <rect x="400" y="150" width="120" height="40" fill="#fff" stroke="#333" rx="5"/>
  <text x="460" y="175" text-anchor="middle" font-family="Arial" font-size="14">EmergencyContact</text>
  
  <!-- Connecting Lines -->
  <line x1="300" y1="70" x2="140" y2="150" stroke="#333" marker-end="url(#arrowhead)"/>
  <line x1="300" y1="70" x2="300" y2="150" stroke="#333" marker-end="url(#arrowhead)"/>
  <line x1="300" y1="70" x2="460" y2="150" stroke="#333" marker-end="url(#arrowhead)"/>
  
  <!-- Arrow Marker -->
  <defs>
    <marker id="arrowhead" markerWidth="10" markerHeight="7" refX="9" refY="3.5" orient="auto">
      <polygon points="0 0, 10 3.5, 0 7" fill="#333"/>
    </marker>
  </defs>
</svg>
ass-hierarchy.svg…]()



### Interface Implementations
- FileFunctions (Interface)
- Calculations (Interface)

## 📁 File Structure
```
./
├── salarydata/
│   └── employee{id}.html
├── userdata/
│   └── employee{id}.html
├── emergencydata/
│   └── emergency_{id}.html
└── userdata.txt
```

## 🔧 Technical Implementation

### Key Components
1. Authentication System
2. Employee Management
3. HTML Generation
4. Exception Handling
5. Directory Management

### Technologies Used
- Java
- HTML
- CSS
- JavaScript

## 💪 Technical Strengths

1. Modularity: Clear separation of concerns through interface implementation
2. Extensibility: Abstract classes and interfaces allow for easy system expansion
3. Data Persistence: HTML-based storage provides both data storage and presentation
4. Input Validation: Comprehensive validation across all user inputs
5. Error Handling: Robust exception handling throughout the system

## 👥 Team Members & Contributions

- **K.S.B. Galkotuwa (EC/2022/053)**
  - MainMenu and EntryPoint classes
  - Interfaces implementation
  - System coordination and integration
  - Integration & System Testing

- **A. Dhilukshy (EC/2022/023)**
  - EmployDetail and Employee_Add classes
  - Person super class implementation
  - Unit Testing

- **G. Varushiny (EC/2022/078)**
  - Employee_Show class
  - Login Menu implementation
  - Documentation
  - Unit Testing

- **R.H.M.P. Rathmalage (EC/2022/002)**
  - Employee_Remove class
  - Register menu
  - Input validation
  - Unit Testing

- **C. Niroshan (EC/2022/077)**
  - Employee_Update and CodeExit classes
  - Error handling
  - CSS Stylesheet
  - Salary Calculator HTML

## 🚀 Future Improvements

1. Enhanced security features
2. Database integration
3. Graphical user interface
4. Data encryption
5. Backup system implementation

## 📹 Demo
Watch our system demonstration: [Vimeo Link](https://vimeo.com/1049384123?share=copy)

## 🙏 Acknowledgments

Special thanks to Dr. B.M.T. Kumarika for her invaluable guidance and support throughout the development of this project. Her expertise in conducting the BECS 12243 module has been instrumental in our understanding of Object-Oriented Programming and software development.

---
© 2025 Employee Management System. Developed as part of BECS 12243 module.
