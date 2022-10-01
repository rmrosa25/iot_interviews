# Table: employees

- `Name`: employees
- `Comment`: employees

## `Primary Key`

- `Columns`: id
- `Cluster`: `false`

## `Indexes[]`

| `Columns`           | `Cluster` | `Unique` |
| ------------------- | --------- | -------- |
| employee_name        | `true`    | `false`  |


## `Columns[]`

| `Label`    | `Name`       | `Type`             | `Nullable` | `Default` | `Comment` |
| ---------- | ------------ | ------------------ | ---------- | --------- | --------- |
| id         | id           | int auto_increment | `false`    |           |           |
| Name       | employee_name | varchar(128)       | `false`    |           |           |
| Department | department_id | int                | `true`    |           |           |
