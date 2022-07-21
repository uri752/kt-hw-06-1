package ru.netology

fun main() {

    val post1 =  Post(
        id = 0,
        ownerId = 1,
        text = "Новая нетология 1",
        date = 1590075360,
        likes = Likes(count = 22),
        attachment = arrayOf(
            PhotoAttachment(),
            VideoAttachment(),
            WikiAttachment()
        )
    )

    val post2 =  Post(
        id = 0,
        ownerId = 1,
        text = "Новая нетология 1",
        date = 1590075360,
        likes = Likes(count = 22)
    )

    post1.attachment.forEach { println(it) }

    val service = WallService

    // функция добавления поста
    val added1 = service.add(post1)
    val added2 = service.add(post2)
    service.addAtachment(added2.id, PhotoAttachment())

    val postWithAttachment = service.getPostById(added2.id)
    println("postWithAttachment: $postWithAttachment")

    println("added1: $added1")

    // функция обновления поста
    var post3 =  Post(
        id = 2,
        ownerId = 1,
        text = "Новая нетология 3",
        date = 1590075360,
        likes = Likes(count = 22)
    )

    val res = service.update(post3)
    println("Пост обновлен: $res")

}
