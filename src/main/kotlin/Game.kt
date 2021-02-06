fun main() {

    val name = "Madrigal"
    val espece = "gnome"
    var healthPoints = 76
    var isBlessed = false
    var isImmortal = false

    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    var healthStatus = formatHealthStatus(healthPoints, isBlessed)
    val faction = playerFaction(espece)

    printPlayerStatus(auraColor, isBlessed, name, healthStatus, faction)
    castFireball()
}

private fun playerFaction(espece: String): String {
    val faction = when (espece) {
        "nain" -> "Gardiens des mines"
        "gnome" -> " Gardiens des mines "
        "orque" -> "Peuple libre des collines"
        "humain" -> " Peuple libre des collines "
        else -> " Unknown peuplade."
    }
    return faction
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) " VERTE" else " NONE"
    return auraColor
}

private fun castFireball(numFireballs: Int = 2) =
    println("Apparition d'un verre de Fireball. (x$numFireballs)")


private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
     when (healthPoints) {
        100 -> "est en farpaite santé!"
        in 90..99 -> "est gratigné..."
        in 75..89 -> if (isBlessed) {
            "est blessé mais se repard vite ;-)"
        } else {
            "est un peu blessé"
        }
        in 15..74 -> "est quand meme bien cassé"
        else -> ", ça sent le sapin!!!"
    }

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String,
    faction: String
) {
    println(
        "(Aura : $auraColor)" +
                "(Béni : ${if (isBlessed) "OUI" else "NON"})"
    )
    println("$name $healthStatus")
    println(faction)
}

