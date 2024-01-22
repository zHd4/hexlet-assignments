@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@import exercise.model.Post
@param PostsPage page

@template.layout.page(
content = @`
    <table class="table">
        <thead></thead>
        <tbody>
        @for(Post post : page.getPosts())
        <tr>
            <td><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></td>
        </tr>
        @endfor
        </tbody>
    </table>

    <div class="mx-auto p-4 py-md-5">
        @if(page.getPreviousPage() != 0)
            <a href="${NamedRoutes.postsPath(page.getPreviousPage())}">&lt;&lt;&lt; Previous</a>
        @endif

        @if(page.getNextPage() != 0)
            <a href="${NamedRoutes.postsPath(page.getNextPage())}" style="margin-left: 50px;">Next &gt;&gt;&gt;</a>
        @endif
    </div>
`
)