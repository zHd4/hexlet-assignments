@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
content = @`
    <div class="mb-3">
        <span>${page.getError()}</span>
    </div>

    <div class="mx-auto p-4 py-md-5">
        <form action="${NamedRoutes.loginPath()}" method="post">
            <div class="mb-3">
                <label class="form-label">
                    Login
                    <input type="text" class="form-control" name="name" value="${page.getName()}" />
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Password
                    <input type="password" class="form-control" name="password" />
                </label>
            </div>
            <input type="submit" class="btn btn-primary" value="Sign In" />
        </form>
    </div>
`
)