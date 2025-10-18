DFC Hangul Club Website

A full-stack Spring Boot web application for managing Korean language lessons, events, attendance, and club communications at the University of Texas at Dallas.

Overview
The DFC Hangul Club Website is a centralized platform built to support the club’s mission of promoting Korean language and culture through:
 - Lesson scheduling & request system
 - Email notifications (SendGrid integration)
 - Event pages and announcements
 - Attendance tracking via QR codes (if enabled)
 - Modern UI with Thymeleaf and CSS
 - Deployed using Render with GitHub integration

Features
 - Language Lesson Booking
    - Interactive schedule with available time slots
    - Students submit lesson requests
    - Sends automatic admin email notifications
    - Admins can process requests manually

Events
 - Displays club activities, workshops, and cultural events
- Can be updated via templates or database (future feature)

Email Notifications
 - Integrated with SendGrid API
 - Secure API key management via environment variables
 - Supports multiple admin recipients

Deploymed
 - Packaged via Maven and Spring Boot
 - Environment variables managed securely on Render
 - Auto-deploy from GitHub commits

Tech Stack
 - Layer	Technology
 - Backend	Java 17, Spring Boot
 - Frontend	Thymeleaf, HTML, CSS
 - Styling	Custom styles.css
 - Database	(Optional) H2/MySQL support
 - Email	SendGrid API
 - Deployment	Render + GitHub CI/CD

Project Structure
DFC_Hangul/
├── src/main/java/com/dfc/hangul
│   ├── controller       # Web controllers
│   ├── model            # DB entities (if enabled)
│   ├── service          # Business logic (Email, Attendance, etc.)
│   └── DfcHangulApplication.java
├── src/main/resources
│   ├── templates        # Thymeleaf pages (home, events, lessons, etc.)
│   │   ├── fragments    # Shared layout/header/footer
│   │   ├── index.html
│   │   ├── lessons.html
│   │   ├── events.html
│   │   └── attendance.html (optional)
│   ├── static/css       # Stylesheets
│   ├── static/img       # Club images
│   └── application.properties.example
├── pom.xml
├── README.md
└── .env (not committed)

Build and Run Locally
 - mvn clean package
 - mvn spring-boot:run

Visit: http://localhost:9090

Lesson Request Email Workflow
 - When a student selects a slot on /lessons:
 - A modal collects their name and selected teacher/time.
 - On submission, a POST request is sent to the backend.
 - EmailService uses SendGrid to send notification emails to admins.
 - Successful sends are logged with status code 202.

Future Enhancements
 - Student login & profile
 - Interactive lesson capacity tracking
 - Database integration (Hibernate + MySQL)
 - Admin dashboard with approval workflow
 - Gallery & photo archive

Contribution Guidelines
Contributions from club officers and developers is welcome. 

Please follow these steps and practice good housekeeping:
 - Fork the repository
 - Create a new branch
 - Commit changes
 - Submit a Pull Request

License
This project is developed by the DFC Hangul Club at UTD and is intended for educational and cultural community use.

Author
AJ Kimbrough - Officer/Developer
📧 ank210005@utdallas.edu

Website maintained by DFC Hangul Club