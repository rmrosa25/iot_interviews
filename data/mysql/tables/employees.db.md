# Table: employees

- `Name`: employees
- `Comment`: employees

## `Primary Key`

- `Columns`: id
- `Cluster`: `false`

## `Indexes[]`

| `Columns`           | `Cluster` | `Unique` |
| ------------------- | --------- | -------- |
| employeeName        | `true`    | `false`  |


## `Columns[]`

| `Label`    | `Name`       | `Type`             | `Nullable` | `Default` | `Comment` |
| ---------- | ------------ | ------------------ | ---------- | --------- | --------- |
| id         | id           | int auto_increment | `false`    |           |           |
| Name       | employeeName | varchar(128)       | `false`    |           |           |
| Department | departmentId | int                | `true`    |           |           |
