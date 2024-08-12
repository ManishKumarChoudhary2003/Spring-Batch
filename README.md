# Spring Batch Processing

This repository contains a Spring Boot project demonstrating batch processing using Spring Batch. The project showcases various batch processing techniques, including file reading, database reading, chunk processing, flow control, and error handling.

## Features

- **Chunk-Based Processing**: Process data in chunks to optimize performance and manage large datasets.
- **Multiple Item Readers**: Use different item readers like `FlatFileItemReader`, `JdbcCursorItemReader`, and `JdbcPagingItemReader`.
- **Fault Tolerance**: Skip faulty records, retry processing on errors, and handle exceptions gracefully.
- **Flow Control**: Manage the execution flow between different steps in the job.

## Project Structure

- **`config/`**: Contains the Spring Batch configuration class.
- **`domain/`**: Contains the domain model (`Product`) and mappers (`ProductFieldSetMapper`, `ProductRowMapper`).
- **`reader/`**: Contains custom item readers like `ProductNameItemReader`.
- **`data/`**: Contains sample CSV files for batch processing.

## Setup and Usage

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- A running database (H2, MySQL, etc.) for JDBC item readers
- Optional: Docker (for containerized database setup)

### Running the Application

1. **Clone the repository**:
    ```bash
    git clone https://github.com/ManishKumarChoudhary2003/Spring-Batch.git
    cd Spring-Batch
    ```

2. **Configure the database**:
   - Update the `application.properties` file with your database configurations if you are using JDBC item readers.
   - Example for MySQL:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
     spring.datasource.username=yourusername
     spring.datasource.password=yourpassword
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build the project**:
    ```bash
    mvn clean install
    ```

4. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

### Batch Job Details

- **Job Name**: `Job1`
  - **Step 1**: Reads data from a CSV file using `FlatFileItemReader` and processes it in chunks.
  - **Step 2**: Reads data from a database using `JdbcCursorItemReader`.
  - **Step 3**: Reads data from a database using `JdbcPagingItemReader`.

### Fault Tolerance and Error Handling

- The batch job is configured to skip any record that causes an exception during processing.
- The job will retry failed records up to 3 times before skipping them.
- These configurations ensure that the job can handle unexpected errors gracefully without stopping the entire process.

## Customizing the Job

- **Adding New Steps**: You can add new steps by creating a new `Step` bean in the `BatchConfiguration` class and updating the job flow.
- **Changing Chunk Size**: Adjust the chunk size in the `step1`, `jdbcItemReaderStep`, or `jdbcPagingItemReaderStep` method according to your processing needs.
- **Modifying Readers/Writers**: Customize the item readers and writers by implementing your logic in the respective beans.


## Contact

For any inquiries, please reach out to [cmanishkumar193@gmail.com](mailto:cmanishkumar193@gmail.com).

