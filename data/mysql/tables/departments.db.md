# Table: departments

- `Name`: departments
- `Comment`: departments

## `Primary Key`

- `Columns`: id
- `Cluster`: `false`

## `Indexes[]`

| `Columns`           | `Cluster` | `Unique` |
| ------------------- | --------- | -------- |
| department_name      | `true`    | `false`  |

## `Columns[]`

| `Label`    | `Name`           | `Type`             | `Nullable` | `Default` | `Comment` |
| ---------- | -----------------| ------------------ | ---------- | --------- | --------- |
| id         | id               | int auto_increment | `false`    |           |           |
| Name       | department_name   | varchar(128)       | `false`    |           |           |
