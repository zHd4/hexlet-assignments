@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <h2>${page.getPost().getName()}</h2>
        <p>${page.getPost().getBody()}</p>
    </div>

    <div class="mx-auto p-4 py-md-5">
        <a href="${NamedRoutes.postsPath()}">Back</a>
    </div>
`
)