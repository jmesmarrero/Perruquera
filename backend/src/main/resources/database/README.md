# Database

This directory contains everything related to the database of the project.

## Structure

- `schema.sql` - Creates the database schema (tables, constraints and relationships).
- `data.sql` - Inserts the initial data required by the application (roles, species, services, etc.).

## Usage

After creating the PostgreSQL database, execute:

```sql
schema.sql
```

Then execute:

```sql
data.sql
```

This will create the database structure and insert the initial records.

## Notes

- `schema.sql` is intended for development.
- Initial data should only include essential records required by the application.
- Future database changes may be managed using migrations.

---

Author: Jorge Mesa Marrero