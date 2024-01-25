@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
    content = @`
    <div class="mx-auto p-4 py-md-5">
        @if(page.getName() != null)
            <span>${page.getName().toString()}</span>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" class="btn btn-primary" value="Выйти" />
            </form>
        @else
            <a href="${NamedRoutes.loginPath()}">Войти</a>
        @endif
    </div>
    `
)