

<=====Spring Boot Job Portal Project Description =====>

This project is a web-based job portal application developed using Spring Boot, JPA, Hibernate, and Thymeleaf.
The application provides functionality for job seekers and recruiters to interact on a job search platform.

Features========================>

For Recruiters:
*	Create and Post Jobs: Recruiters can create new job posts to attract job candidates.
*	View Posted Jobs: Access a list of all job posts created by the recruiter.
*	Manage Candidates: View the list of candidates who have applied for specific jobs.
*	Edit Profile: Update profile information, including uploading a profile photo.

For Job Candidates:
*	Job Search: Browse and search for available job listings.
*	Apply for Jobs: Submit applications for jobs posted on the platform.
*	Application Management: View the list of jobs that the candidate has applied to.
*	Edit Profile: Update personal information and upload a resumé/CV.

Common Features:
*	User Registration: Register as either a recruiter or job candidate.
*	Login/Logout: Secure login and logout functionality for all users.

Prerequisites
*	Java: Prior experience with Java is recommended.
*	Spring Boot: Knowledge of Spring Boot for building applications.
*	JPA / Hibernate: Familiarity with ORM tools for managing database entities.
*	Thymeleaf / HTML: Basic understanding of Thymeleaf for server-side rendering.
*	Maven: For dependency management.




Development Environment============>

To set up the development environment, the following tools are recommended:
*	IDE: IntelliJ or Eclipse.
*	Database: MySQL Database Server and MySQL Workbench.




Project Architecture===>
The application follows a standard Spring Boot MVC architecture:
*	Controller Layer: Handles web requests.
*	Service Layer: Implements business logic.
*	Repository Layer: Accesses and manages the database.
*	View Layer: Utilizes Thymeleaf templates for UI rendering.



Database Entities  =================>

Key database entities include:
*	JobCompany: Company information.
*	JobPostActivity: Details of each job post.
*	JobSeekerProfile: Candidate profile details.
*	RecruiterProfile: Recruiter profile details.
*	Skills: Skills associated with candidates.


Getting Started  ================>

1. Set Up Database
1.	Create a MySQL user and database for the application.
2.	Import the provided SQL scripts for initial setup.
2. Build and Run the Application
Use Maven to build the project:

Copy code
mvn clean install


Then, run the application:


Copy code
mvn spring-boot:run

4. Access the Application
Once the application is running, access it through a web browser at:
http://localhost:8080


Contributing  ================>

Feel free to contribute by reporting issues or submitting pull requests.

