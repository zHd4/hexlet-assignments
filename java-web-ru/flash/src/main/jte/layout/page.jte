@import exercise.util.NamedRoutes
@import exercise.dto.BasePage
@import gg.jte.Content
@param Content content
@param BasePage page = null

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Posts app</title>
</head>
<body>
@if(page != null && page.getFlash() != null)
    <div class="alert alert-success" role="alert">
        ${page.getFlash()}
    </div>
@endif
${content}
</body>
</html>
