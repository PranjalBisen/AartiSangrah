package com.example.myapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapp.ui.screens.*
import com.example.myapp.ui.screens.about.AboutScreen
import com.example.myapp.ui.screens.devi.AigiriNandini
import com.example.myapp.ui.screens.devi.AmbeTuHai
import com.example.myapp.ui.screens.devi.DurgaChalisa
import com.example.myapp.ui.screens.devi.DeviScreen
import com.example.myapp.ui.screens.devi.DurgeDurghatBhari
import com.example.myapp.ui.screens.devi.JaiAmbeGauri
import com.example.myapp.ui.screens.devi.KamakshiStotram
import com.example.myapp.ui.screens.devi.MahalakshmiAshtakam
import com.example.myapp.ui.screens.devi.TulsiMangalashtak
import com.example.myapp.ui.screens.devi.YaKundendu
import com.example.myapp.ui.screens.ganpati.EkadantayaVakratundaya
import com.example.myapp.ui.screens.ganpati.GaneshPanchratnam
import com.example.myapp.ui.screens.ganpati.GanpatiAtharvashirsha
import com.example.myapp.ui.screens.ganpati.GanpatiJiKiSewa
import com.example.myapp.ui.screens.ganpati.GanpatiScreen
import com.example.myapp.ui.screens.ganpati.JaiGanesh
import com.example.myapp.ui.screens.ganpati.ShendurLal
import com.example.myapp.ui.screens.ganpati.SukhKartaDukhHarta
import com.example.myapp.ui.screens.hanuman.AartiKijiyeHanumanLala
import com.example.myapp.ui.screens.hanuman.BajrangBaan
import com.example.myapp.ui.screens.hanuman.HanumanAshtak
import com.example.myapp.ui.screens.hanuman.HanumanChalisa
import com.example.myapp.ui.screens.hanuman.HanumanScreen
import com.example.myapp.ui.screens.hanuman.JaiJaiJaiHanumanGosai
import com.example.myapp.ui.screens.hanuman.MangalMurtiMarutiNandan
import com.example.myapp.ui.screens.mantra.BudhBeejMantra
import com.example.myapp.ui.screens.mantra.ChandraBeejMantra
import com.example.myapp.ui.screens.mantra.DigambaraDigambara
import com.example.myapp.ui.screens.mantra.GuruBeejMantra
import com.example.myapp.ui.screens.mantra.HanumanBeejMantra
import com.example.myapp.ui.screens.mantra.KeetuBeejMantra
import com.example.myapp.ui.screens.mantra.KrishnayaVasudevay
import com.example.myapp.ui.screens.mantra.MahalakshmiBeejMantra
import com.example.myapp.ui.screens.mantra.MangalBeejMantra
import com.example.myapp.ui.screens.mantra.MantraScreen
import com.example.myapp.ui.screens.mantra.OmGanGanpateyNamah
import com.example.myapp.ui.screens.mantra.OmNamahShivay
import com.example.myapp.ui.screens.mantra.OmNamoBhagwateVasudevay
import com.example.myapp.ui.screens.mantra.OmTriyambakam
import com.example.myapp.ui.screens.mantra.RahuBeejMantra
import com.example.myapp.ui.screens.mantra.SaraswatiBeejMantra
import com.example.myapp.ui.screens.mantra.ShaniBeejMantra
import com.example.myapp.ui.screens.mantra.ShukraBeejMantra
import com.example.myapp.ui.screens.mantra.SuryaBeejMantra
import com.example.myapp.ui.screens.saibaba.GhanshyamSundara
import com.example.myapp.ui.screens.saibaba.RusoMamaPriyambika
import com.example.myapp.ui.screens.saibaba.SadaSatswaroopam
import com.example.myapp.ui.screens.saibaba.SaiBabaScreen
import com.example.myapp.ui.screens.saibaba.UthaUthaSakala
import com.example.myapp.ui.screens.shiva.AavadTulaBelachi
import com.example.myapp.ui.screens.shiva.KaalBhairavAshtakam
import com.example.myapp.ui.screens.shiva.KarpurGauraGauriShankara
import com.example.myapp.ui.screens.shiva.LavthavtiVikrala
import com.example.myapp.ui.screens.shiva.OmJaiShivOmkara
import com.example.myapp.ui.screens.shiva.Rudrashtakam
import com.example.myapp.ui.screens.shiva.ShivTandavStotram
import com.example.myapp.ui.screens.shiva.ShivaScreen
import com.example.myapp.ui.screens.vishnu.AchyutamKeshavam
import com.example.myapp.ui.screens.vishnu.KanadaRajaPandharicha
import com.example.myapp.ui.screens.vishnu.KishoriKuchAisa
import com.example.myapp.ui.screens.vishnu.KunjBihariAarti
import com.example.myapp.ui.screens.vishnu.MazheMaherPandhari
import com.example.myapp.ui.screens.vishnu.OmJaiJagdishHare
import com.example.myapp.ui.screens.vishnu.OvaluAartiMadanGopala
import com.example.myapp.ui.screens.vishnu.ShriHariStotram
import com.example.myapp.ui.screens.vishnu.ShriKrishnaGovindHareMurari
import com.example.myapp.ui.screens.vishnu.ShriVenkateshaStotram
import com.example.myapp.ui.screens.vishnu.VishnuScreen
import com.example.templefinder.TempleMapScreen

object Routes {
    const val HOME = "home"
    const val DAYS_SCREEN = "days_screen"
    const val MANTRA_SCREEN = "mantra_screen"
    const val TEMPLE_MAP = "temple_map"
    const val ABOUT_SCREEN = "about_screen"

    const val GANPATI_SCREEN = "ganpati_screen"
    const val SHIVA_SCREEN = "shiva_screen"
    const val HANUMAN_SCREEN = "hanuman_screen"
    const val VISHNU_SCREEN = "vishnu_screen"
    const val DURGA_SCREEN = "durga_screen"
    const val SAIBABA_SCREEN = "saibaba_screen"

    const val SPIRITUAL_CORNER = "spiritual_corner"
    const val TRYAMBAKAM_SCREEN = "tryambakam_screen"
    const val GAYATRI_SCREEN = "gayatri_screen"
    const val HANUMAN_MANTRA_SCREEN = "hanuman_mantra_screen"
    const val KRISHNA_MANTRA_SCREEN = "krishna_mantra_screen"

    const val AARTI_1 = "ganpati_aarti_1"
    const val AARTI_2 = "ganpati_aarti_2"
    const val AARTI_3 = "ganpati_aarti_3"
    const val AARTI_4 = "ganpati_aarti_4"
    const val AARTI_5 = "ganpati_aarti_5"
    const val AARTI_6 = "ganpati_aarti_6"
    const val AARTI_7 = "ganpati_aarti_7"


    const val HANUMAN_AARTI_1 = "hanuman_aarti_1"
    const val HANUMAN_AARTI_2 = "hanuman_aarti_2"
    const val HANUMAN_AARTI_3 = "hanuman_aarti_3"
    const val HANUMAN_AARTI_4 = "hanuman_aarti_4"
    const val HANUMAN_AARTI_5 = "hanuman_aarti_5"
    const val HANUMAN_AARTI_6 = "hanuman_aarti_6"

    const val SHIVA_AARTI_1 = "shiva_aarti_1"
    const val SHIVA_AARTI_2 = "shiva_aarti_2"
    const val SHIVA_AARTI_3 = "shiva_aarti_3"
    const val SHIVA_AARTI_4 = "shiva_aarti_4"
    const val SHIVA_AARTI_5 = "shiva_aarti_5"
    const val SHIVA_AARTI_6 = "shiva_aarti_6"
    const val SHIVA_AARTI_7 = "shiva_aarti_7"


    const val KRISHNA_AARTI_1 = "krishna_aarti_1"
    const val KRISHNA_AARTI_2 = "krishna_aarti_2"
    const val KRISHNA_AARTI_3 = "krishna_aarti_3"
    const val KRISHNA_AARTI_4 = "krishna_aarti_4"
    const val KRISHNA_AARTI_5 = "krishna_aarti_5"
    const val KRISHNA_AARTI_6 = "krishna_aarti_6"
    const val KRISHNA_AARTI_7 = "krishna_aarti_7"
    const val KRISHNA_AARTI_8 = "krishna_aarti_8"
    const val KRISHNA_AARTI_9 = "krishna_aarti_9"
    const val KRISHNA_AARTI_10 = "krishna_aarti_10"


    const val DURGA_AARTI_1 = "durga_aarti_1"
    const val DURGA_AARTI_2 = "durga_aarti_2"
    const val DURGA_AARTI_3 = "durga_aarti_3"
    const val DURGA_AARTI_4 = "durga_aarti_4"
    const val DURGA_AARTI_5 = "durga_aarti_5"
    const val DURGA_AARTI_6 = "durga_aarti_6"
    const val DURGA_AARTI_7 = "durga_aarti_7"
    const val DURGA_AARTI_8 = "durga_aarti_8"
    const val DURGA_AARTI_9 = "durga_aarti_9"



    const val SAIBABA_AARTI_1 = "saibaba_aarti_1"
    const val SAIBABA_AARTI_2 = "saibaba_aarti_2"
    const val SAIBABA_AARTI_3 = "saibaba_aarti_3"
    const val SAIBABA_AARTI_4 = "saibaba_aarti_4"


    const val OM_NAMAH_SHIVAY= "om_namah_shivay"
    const val OM_GAN_GANPATAYE_NAMAH= "om_gan_ganpatey_namah"
    const val OM_TRIYAMBAKAM= "om_triyambakam"
    const val DIGAMBARA_DIGAMBARA= "digambara_digambara"
    const val MAHALAKSHMI_BEEJ_MANTRA = "mahalakshmi_beej_mantra"
    const val HANUMAN_BEEJ_MANTRA = "hanuman_beej_mantra"
    const val SARASWATI_BEEJ_MANTRA = "saraswati_beej_mantra"
    const val KRISHNAYA_VASUDEVAY  = "krishnaya_vasudevay"
    const val OM_NAMO_BHAGWATE_VASUDEVAY = "om_namo_bhagwate_vasudevay"
    const val SURYA_BEEJ_MANTRA = "surya_beej_mantra"
    const val CHANDRA_BEEJ_MANTRA = "chandra_beej_mantra"
    const val MANGAL_BEEJ_MANTRA = "mangal_beej_mantra"
    const val BUDH_BEEJ_MANTRA = "budh_beej_mantra"
    const val GURU_BEEJ_MANTRA = "guru_beej_mantra"
    const val SHUKRA_BEEJ_MANTRA = "shukra_beej_mantra"
    const val SHANI_BEEJ_MANTRA = "shani_beej_mantra"
    const val RAHU_BEEJ_MANTRA = "rahu_beej_mantra"
    const val KETU_BEEJ_MANTRA= "ketu_beej_mantra"

}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) { HomeScreen(navController) }
        composable(Routes.DAYS_SCREEN) { DaysScreen(navController) }
        composable(Routes.SPIRITUAL_CORNER) { SpiritualCornerScreen(navController) }
        composable(Routes.TEMPLE_MAP) { TempleMapScreen() }
        composable(Routes.MANTRA_SCREEN) { MantraScreen(navController) }
        composable(Routes.ABOUT_SCREEN) { AboutScreen() }

        composable(Routes.GANPATI_SCREEN) { GanpatiScreen(navController) }
        composable(Routes.SHIVA_SCREEN) { ShivaScreen(navController) }
        composable(Routes.HANUMAN_SCREEN) { HanumanScreen(navController) }
        composable(Routes.VISHNU_SCREEN) { VishnuScreen(navController) }
        composable(Routes.DURGA_SCREEN) { DeviScreen(navController) }
        composable(Routes.SAIBABA_SCREEN) { SaiBabaScreen(navController) }

        composable(Routes.AARTI_1) { SukhKartaDukhHarta(navController) }
        composable(Routes.AARTI_2) { JaiGanesh(navController) }
        composable(Routes.AARTI_3) { ShendurLal(navController) }
        composable(Routes.AARTI_4) { GanpatiJiKiSewa(navController) }
        composable(Routes.AARTI_5) { GanpatiAtharvashirsha(navController) }
        composable(Routes.AARTI_6) { EkadantayaVakratundaya(navController) }
        composable(Routes.AARTI_7) { GaneshPanchratnam(navController) }



        composable(Routes.HANUMAN_AARTI_1) { AartiKijiyeHanumanLala(navController) }
        composable(Routes.HANUMAN_AARTI_2) { HanumanChalisa(navController) }
        composable(Routes.HANUMAN_AARTI_3) { HanumanAshtak(navController) }
        composable(Routes.HANUMAN_AARTI_4) { BajrangBaan(navController) }
        composable(Routes.HANUMAN_AARTI_5) { JaiJaiJaiHanumanGosai(navController) }
        composable(Routes.HANUMAN_AARTI_6) { MangalMurtiMarutiNandan(navController) }


        composable(Routes.SHIVA_AARTI_1) { LavthavtiVikrala(navController) }
        composable(Routes.SHIVA_AARTI_2) { KarpurGauraGauriShankara(navController) }
        composable(Routes.SHIVA_AARTI_3) { OmJaiShivOmkara(navController) }
        composable(Routes.SHIVA_AARTI_4) { AavadTulaBelachi(navController) }
        composable(Routes.SHIVA_AARTI_5) { ShivTandavStotram(navController) }
        composable(Routes.SHIVA_AARTI_6) { Rudrashtakam(navController) }
        composable(Routes.SHIVA_AARTI_7) { KaalBhairavAshtakam(navController) }


        composable(Routes.KRISHNA_AARTI_1) { OvaluAartiMadanGopala(navController) }
        composable(Routes.KRISHNA_AARTI_2) { KunjBihariAarti(navController) }
        composable(Routes.KRISHNA_AARTI_3) { OmJaiJagdishHare(navController) }
        composable(Routes.KRISHNA_AARTI_4) { KishoriKuchAisa(navController) }
        composable(Routes.KRISHNA_AARTI_5) { MazheMaherPandhari(navController) }
        composable(Routes.KRISHNA_AARTI_6) { KanadaRajaPandharicha(navController) }
        composable(Routes.KRISHNA_AARTI_7) { AchyutamKeshavam(navController) }
        composable(Routes.KRISHNA_AARTI_8) { ShriKrishnaGovindHareMurari(navController) }
        composable(Routes.KRISHNA_AARTI_9) { ShriHariStotram(navController) }
        composable(Routes.KRISHNA_AARTI_10) { ShriVenkateshaStotram(navController) }


        composable(Routes.DURGA_AARTI_1) { DurgeDurghatBhari(navController) }
        composable(Routes.DURGA_AARTI_2) { JaiAmbeGauri(navController) }
        composable(Routes.DURGA_AARTI_3) { AmbeTuHai(navController) }
        composable(Routes.DURGA_AARTI_4) { DurgaChalisa(navController) }
        composable(Routes.DURGA_AARTI_5) { KamakshiStotram(navController) }
        composable(Routes.DURGA_AARTI_6) { MahalakshmiAshtakam(navController) }
        composable(Routes.DURGA_AARTI_7) { TulsiMangalashtak(navController) }
        composable(Routes.DURGA_AARTI_8) { YaKundendu(navController) }
        composable(Routes.DURGA_AARTI_9) { AigiriNandini(navController) }

        composable(Routes.SAIBABA_AARTI_1) { SadaSatswaroopam(navController) }
        composable(Routes.SAIBABA_AARTI_2) { RusoMamaPriyambika(navController) }
        composable(Routes.SAIBABA_AARTI_3) { GhanshyamSundara(navController) }
        composable(Routes.SAIBABA_AARTI_4) { UthaUthaSakala(navController) }


        composable(Routes.OM_NAMAH_SHIVAY) { OmNamahShivay(navController) }
        composable(Routes.OM_GAN_GANPATAYE_NAMAH) { OmGanGanpateyNamah(navController) }
        composable(Routes.OM_TRIYAMBAKAM) { OmTriyambakam(navController) }
        composable(Routes.DIGAMBARA_DIGAMBARA) { DigambaraDigambara(navController) }
        composable(Routes.MAHALAKSHMI_BEEJ_MANTRA) { MahalakshmiBeejMantra(navController) }
        composable(Routes.HANUMAN_BEEJ_MANTRA) { HanumanBeejMantra(navController) }
        composable(Routes.SARASWATI_BEEJ_MANTRA) { SaraswatiBeejMantra(navController) }
        composable(Routes.KRISHNAYA_VASUDEVAY) { KrishnayaVasudevay(navController) }
        composable(Routes.OM_NAMO_BHAGWATE_VASUDEVAY) { OmNamoBhagwateVasudevay(navController) }
        composable(Routes.SURYA_BEEJ_MANTRA) { SuryaBeejMantra(navController) }
        composable(Routes.CHANDRA_BEEJ_MANTRA) { ChandraBeejMantra(navController) }
        composable(Routes.MANGAL_BEEJ_MANTRA) { MangalBeejMantra(navController) }
        composable(Routes.BUDH_BEEJ_MANTRA) { BudhBeejMantra(navController) }
        composable(Routes.GURU_BEEJ_MANTRA) { GuruBeejMantra(navController) }
        composable(Routes.SHUKRA_BEEJ_MANTRA) { ShukraBeejMantra(navController) }
        composable(Routes.SHANI_BEEJ_MANTRA) { ShaniBeejMantra(navController) }
        composable(Routes.RAHU_BEEJ_MANTRA) { RahuBeejMantra(navController) }
        composable(Routes.KETU_BEEJ_MANTRA) { KeetuBeejMantra(navController) }


    }
}
