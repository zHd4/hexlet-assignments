@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            html {
              font: 18px/1.5 sans-serif;
            }

            body {
              background-color: #1e2121;
            }

            a {
              color: unset;
            }

            table {
              color: #fff;
              background-color: #343a40;
              margin-left: auto;
              margin-right: auto;
            }

            caption {
              visibility: hidden;
            }

            td,
            th {
              padding: 1em;
            }

            th {
              text-align: left;
              vertical-align: bottom;
            }

            tbody tr {
              background-color: #2e3338;
            }

            .text-right {
              text-align: right;
            }

            .text-bold {
              font-weight: bold;
            }

            td.no-users {
              text-align: center;
            }
        </style>

        <title>Users</title>
    </head>
    <body>
        <table>
            <caption>Users</caption>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>
            </thead>

            <tbody>
                @if(!page.getUsers().isEmpty())
                    @for(User user : page.getUsers())
                        <tr>
                            <td><a href="/users/${user.getId()}" target="_blank">${user.getId()}</a></td>
                            <td>${user.getFirstName()}</td>
                            <td>${user.getLastName()}</td>
                            <td>${user.getEmail()}</td>
                        </tr>
                    @endfor
                @else
                    <tr><td class="no-users" colspan="4">No users</td></tr>
                @endif
            </tbody>
        </table>
    </body>
</html>
