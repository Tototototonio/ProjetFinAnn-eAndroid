fun createSeriesList(): MutableList<Test> {
    val seriesList = mutableListOf<Test>()
    seriesList.add(Contenu)
    return seriesList
}

val Contenu = Test(
    story = "The missions of the Strategic Homeland Intervention, Enforcement and Logistics Division. A small team of operatives led by Agent Coulson (Clark Gregg) who must deal with the strange new world of \"superheroes\" after the \"Battle of New York\", protecting the public from new and unknown threats.",
    episodes = mutableListOf<Episode>(
        Episode("https://comicvine.gamespot.com/a/uploads/scale_small/7/76663/3330523-marvels-agents-of-shield.jpg", "Pilot", 1),
        Episode("https://comicvine.gamespot.com/a/uploads/scale_small/0/40/3346846-coulson.jpg", "0-8-4", 2),
        Episode("https://comicvine.gamespot.com/a/uploads/scale_small/0/40/3363120-asset231-710x400.jpg", "The Asset", 3),
        Episode("https://comicvine.gamespot.com/a/uploads/scale_small/6/64675/3369543-133228_8082_pre.jpg", "Eye Spy", 4),

    ),
    persos = mutableListOf<Perso>(
        Perso("Jemma Simmons", "https://comicvine.gamespot.com/a/uploads/scale_small/7/79073/4998056-jemma%20simmons%20%28earth-616%29%20002.jpg"),
        Perso("Quake", "https://comicvine.gamespot.com/a/uploads/scale_small/3/31666/4629368-quake2015001-cov-0aca1.jpg"),
        Perso( "Melinda May", "https://comicvine.gamespot.com/a/uploads/scale_small/0/3848/4629523-cavalry2015001-cov-9fefd.jpg"),
        Perso( "Phil Coulson", "https://comicvine.gamespot.com/a/uploads/scale_small/10/100647/3711822-sonofcoul.jpg"),
    ),
    année = 2013,
    producteur = "Marvel",
    titre = "Agents of SHIELD",
    img = "https://comicvine.gamespot.com/a/uploads/original/6/67663/6678758-6399865442-PAyOXD97w4txFMdr4_Jg0h-OkSmoyPs2uw5B9Tf0GWRysfUemPfeneFwSuEcnTrgzdg%3Ds2000",

)