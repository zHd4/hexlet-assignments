@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

@template.layout.page(
content = @`
    <style>
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

    <table>
        <caption>Users</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
        </tr>
        </thead>

        <tbody>
        @if(!page.getUsers().isEmpty())
            @for(User user : page.getUsers())
                <tr>
                    <td><a href="/users/${user.getId()}" target="_blank">${user.getId()}</a></td>
                    <td>${user.getFirstName()} ${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                </tr>
            @endfor
        @else
            <tr><td class="no-users" colspan="3">No users</td></tr>
        @endif
        </tbody>
    </table>
`
)
