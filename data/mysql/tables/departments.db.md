# Table: departments

- `Name`: departments
- `Comment`: departments

## `Primary Key`

- `Columns`: id
- `Cluster`: `false`

## `Indexes[]`

| `Columns`           | `Cluster` | `Unique` |
| ------------------- | --------- | -------- |
| departmentName      | `true`    | `false`  |

## `Columns[]`

| `Label`    | `Name`           | `Type`             | `Nullable` | `Default` | `Comment` |
| ---------- | -----------------| ------------------ | ---------- | --------- | --------- |
| id         | id               | int auto_increment | `false`    |           |           |
| Name       | departmentName   | varchar(128)       | `false`    |           |           |
