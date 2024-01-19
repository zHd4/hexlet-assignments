@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

@template.layout.page(
content = @`
    <form>
        <label>
            Search name:
            <input type="search" name="term" placeholder="Search name..." value="${page.getTerm()}" required>
        </label>
    </form>

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
        @for(User user : page.getUsers())
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getFirstName()} ${user.getLastName()}</td>
                <td>${user.getEmail()}</td>
            </tr>
        @endfor
        </tbody>
    </table>
`
)