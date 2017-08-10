package com.company;

import com.company.table.Table;
import com.company.table.TableBuilder;
import com.company.table.field.Field;
import com.company.table.field.FieldBuilder;
import com.company.table.field.FieldType;
import com.company.table.field.ForeignKey;
import java.util.ArrayList;
import java.util.List;

public class Tables {

    public List<Table> createTables() {
        List<Table> tables = new ArrayList<>();

        // STUDENT TABLE AND FIELDS START //
        List<Field> studentsFields = new ArrayList<>();
        Field studentsID = new FieldBuilder()
                .fieldName("student_id")
                .fieldType(FieldType.INTEGER)
                .primaryKey(true)
                .notNull(true)
                .autoIncrement(true)
                .fieldComment("students ID")
                .build();

        Field studentsFirstName = new FieldBuilder()
                .fieldName("student_firstname")
                .fieldType(FieldType.STRING)
                .build();

        Field studentsLastName = new FieldBuilder()
                .fieldName("student_lastname")
                .fieldType(FieldType.STRING)
                .build();

        Field studentsAddress = new FieldBuilder()
                .fieldName("student_address")
                .fieldType(FieldType.STRING)
                .build();

        Field studentsCity = new FieldBuilder()
                .fieldName("student_city")
                .fieldType(FieldType.STRING)
                .build();

        studentsFields.add(studentsID);
        studentsFields.add(studentsFirstName);
        studentsFields.add(studentsLastName);
        studentsFields.add(studentsAddress);
        studentsFields.add(studentsCity);

        Table students = new TableBuilder()
                .tableName("students")
                .fields(studentsFields)
                .comment("Student table")
                .build();
        // STUDENT TABLE AND FIELDS END //

        // STUDENT TRANSACTION TABLE AND FIELDS START //
        List<Field> studentTransactionsFields = new ArrayList<>();
        Field transactionID = new FieldBuilder()
                .fieldName("transaction_id")
                .fieldType(FieldType.INTEGER)
                .primaryKey(true)
                .notNull(true)
                .autoIncrement(true)
                .build();

        Field transactionStudentID = new FieldBuilder()
                .fieldName("student_id")
                .fieldType(FieldType.INTEGER)
                .foreignKey(new ForeignKey("students", "students_id"))
                .build();

        Field transactionPostDate = new FieldBuilder()
                .fieldName("post_date")
                .fieldType(FieldType.DATE)
                .build();

        Field transactionAmount = new FieldBuilder()
                .fieldName("amount")
                .fieldType(FieldType.INTEGER)
                .build();

        Field transactionDescription = new FieldBuilder()
                .fieldName("description")
                .fieldType(FieldType.STRING)
                .build();

        studentTransactionsFields.add(transactionID);
        studentTransactionsFields.add(transactionStudentID);
        studentTransactionsFields.add(transactionPostDate);
        studentTransactionsFields.add(transactionAmount);
        studentTransactionsFields.add(transactionDescription);

        Table studentTransactions = new TableBuilder()
                .tableName("student_transactions")
                .fields(studentTransactionsFields)
                .comment("Students transactions")
                .build();
        // STUDENT TRANSACTION TABLE AND FIELDS END //

        // STUDENT ENROLLMENTS TABLE AND FIELDS START //
        List<Field> enrollmentsFields = new ArrayList<>();
        Field enrollmentsCourseID = new FieldBuilder()
                .fieldName("course_id")
                .fieldType(FieldType.INTEGER)
                .foreignKey(new ForeignKey("courses", "course_id"))
                .build();

        Field enrollmentsSection = new FieldBuilder()
                .fieldName("section")
                .fieldType(FieldType.INTEGER)
                .primaryKey(true)
                .notNull(true)
                .autoIncrement(true)
                .build();

        Field enrollmentsStudentID = new FieldBuilder()
                .fieldName("student_id")
                .fieldType(FieldType.INTEGER)
                .foreignKey(new ForeignKey("students", "student_id"))
                .build();

        enrollmentsFields.add(enrollmentsCourseID);
        enrollmentsFields.add(enrollmentsSection);
        enrollmentsFields.add(enrollmentsStudentID);

        Table enrollments = new TableBuilder()
                .tableName("enrollments")
                .fields(enrollmentsFields)
                .comment("Students Enrollments")
                .build();
        // STUDENT ENROLLMENTS TABLE AND FIELDS END //

        // COURSES TABLE AND FIELDS START //
        List<Field> coursesFields = new ArrayList<>();
        Field courseID = new FieldBuilder()
                .fieldName("course_id")
                .fieldType(FieldType.INTEGER)
                .primaryKey(true)
                .notNull(true)
                .autoIncrement(true)
                .build();

        Field courseDepartmentID = new FieldBuilder()
                .fieldName("department_id")
                .fieldType(FieldType.INTEGER)
                .foreignKey(new ForeignKey("departments", "department_id"))
                .build();

        Field courseName = new FieldBuilder()
                .fieldName("name")
                .fieldType(FieldType.STRING)
                .build();

        Field courseUnits = new FieldBuilder()
                .fieldName("units")
                .fieldType(FieldType.STRING)
                .build();

        Field courseCost = new FieldBuilder()
                .fieldName("cost")
                .fieldType(FieldType.INTEGER)
                .build();

        coursesFields.add(courseID);
        coursesFields.add(courseDepartmentID);
        coursesFields.add(courseName);
        coursesFields.add(courseUnits);
        coursesFields.add(courseCost);

        Table courses = new TableBuilder()
                .tableName("courses")
                .fields(coursesFields)
                .comment("Courses table")
                .build();
        // COURSES TABLE AND FIELDS END //

        // GRADES TABLE AND FIELDS START //
        List<Field> gradesFields = new ArrayList<>();
        Field gradesStudentID = new FieldBuilder()
                .fieldName("student_id")
                .fieldType(FieldType.INTEGER)
                .foreignKey(new ForeignKey("students", "student_id"))
                .build();

        Field gradesCourseID = new FieldBuilder()
                .fieldName("course_id")
                .fieldType(FieldType.INTEGER)
                .foreignKey(new ForeignKey("courses", "course_id"))
                .build();

        Field gradesYear = new FieldBuilder()
                .fieldName("year")
                .fieldType(FieldType.YEAR)
                .build();

        Field gradesSemester = new FieldBuilder()
                .fieldName("semester")
                .fieldType(FieldType.INTEGER)
                .build();

        Field gradesGrade = new FieldBuilder()
                .fieldName("grade")
                .fieldType(FieldType.INTEGER)
                .build();

        gradesFields.add(gradesStudentID);
        gradesFields.add(gradesCourseID);
        gradesFields.add(gradesYear);
        gradesFields.add(gradesSemester);
        gradesFields.add(gradesGrade);

        Table grades = new TableBuilder()
                .tableName("grades")
                .fields(gradesFields)
                .comment("Grades table")
                .build();
        // GRADES TABLE AND FIELDS END //

        // SECTIONS TABLE AND FIELDS START //
        List<Field> sectionsFields = new ArrayList<>();
        Field sectionsCourseID = new FieldBuilder()
                .fieldName("course_id")
                .fieldType(FieldType.INTEGER)
                .foreignKey(new ForeignKey("courses", "course_id"))
                .build();

        Field sectionsSection = new FieldBuilder()
                .fieldName("section")
                .fieldType(FieldType.STRING)
                .foreignKey(new ForeignKey("enrollments", "section"))
                .build();

        Field sectionsDays = new FieldBuilder()
                .fieldName("days")
                .fieldType(FieldType.INTEGER)
                .build();

        Field sectionsStartTime = new FieldBuilder()
                .fieldName("start_time")
                .fieldType(FieldType.DATETIME)
                .build();

        Field sectionsLength = new FieldBuilder()
                .fieldName("length")
                .fieldType(FieldType.INTEGER)
                .build();

        Field sectionsProfessorID = new FieldBuilder()
                .fieldName("professor_id")
                .fieldType(FieldType.INTEGER)
                .foreignKey(new ForeignKey("employees", "employer_id"))
                .build();

        Field sectionsCapacity = new FieldBuilder()
                .fieldName("capacity")
                .fieldType(FieldType.INTEGER)
                .build();

        sectionsFields.add(sectionsCourseID);
        sectionsFields.add(sectionsSection);
        sectionsFields.add(sectionsDays);
        sectionsFields.add(sectionsStartTime);
        sectionsFields.add(sectionsLength);
        sectionsFields.add(sectionsProfessorID);
        sectionsFields.add(sectionsCapacity);

        Table sections = new TableBuilder()
                .tableName("sections")
                .fields(sectionsFields)
                .comment("Sections table")
                .build();
        // SECTIONS TABLE AND FIELDS END //

        // EMPLOYEES TABLE AND FIELDS START //
        List<Field> employeesFields = new ArrayList<>();
        Field employerID = new FieldBuilder()
                .fieldName("employer_id")
                .fieldType(FieldType.INTEGER)
                .primaryKey(true)
                .notNull(true)
                .autoIncrement(true)
                .build();

        Field employeesFirstName = new FieldBuilder()
                .fieldName("first_name")
                .fieldType(FieldType.STRING)
                .build();

        Field employeesLastName = new FieldBuilder()
                .fieldName("last_name")
                .fieldType(FieldType.STRING)
                .build();

        Field employeesSalary = new FieldBuilder()
                .fieldName("salary")
                .fieldType(FieldType.INTEGER)
                .build();

        Field employeesDepartmentID = new FieldBuilder()
                .fieldName("department_id")
                .fieldType(FieldType.INTEGER)
                .foreignKey(new ForeignKey("departments", "department_id"))
                .build();

        employeesFields.add(employerID);
        employeesFields.add(employeesFirstName);
        employeesFields.add(employeesLastName);
        employeesFields.add(employeesSalary);
        employeesFields.add(employeesDepartmentID);

        Table employees = new TableBuilder()
                .tableName("employees")
                .fields(employeesFields)
                .comment("Employees table")
                .build();
        // EMPLOYEES TABLE AND FIELDS END //

        // DEPARTMENT TABLE AND FIELDS START //
        List<Field> departmentFields = new ArrayList<>();
        Field departmentID = new FieldBuilder()
                .fieldName("department_id")
                .fieldType(FieldType.INTEGER)
                .build();

        Field description = new FieldBuilder()
                .fieldName("description")
                .fieldType(FieldType.STRING)
                .build();

        departmentFields.add(departmentID);
        departmentFields.add(description);

        Table departments = new TableBuilder()
                .tableName("departments")
                .fields(departmentFields)
                .comment("Department table")
                .build();
        // DEPARTMENT TABLE AND FIELDS END //

        tables.add(students);
        tables.add(studentTransactions);
        tables.add(enrollments);
        tables.add(courses);
        tables.add(grades);
        tables.add(sections);
        tables.add(employees);
        tables.add(departments);

        return tables;
    }

}
