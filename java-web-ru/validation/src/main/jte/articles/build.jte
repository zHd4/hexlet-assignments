@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
    content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/articles" method="post">
        <div class="form-group">
            <label>
                Название
                <input type="text" class="form-control" name="title" placeholder="Введите название" value="${page.getTitle()}" required/>
            </label>
        </div>
        <div class="form-group">
            <label>
                Текст статьи
                <textarea class="form-control" name="content" placeholder="Введите текст" required>${page.getContent()}</textarea>
            </label>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Добавить</button>
        </div>
    </form>
    `
)