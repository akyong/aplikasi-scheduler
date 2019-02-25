package aplikasi.scheduler;

import io.micronaut.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Singleton;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Contoh Aplikasi Microservices - 'Scheduler'</p>
 * Aplikasi ini dibuat untuk membantu memudahkan para pembaca lebih memahami
 * tentang pembuatan aplikasi penjadwalan.
 *
 * @author akyong
 * */
@Singleton
public class HelloWorldJob {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldJob.class);

    /*
    * Penjadwalan dengan jangka waktu yang pasti adalah setiap 10 detik
    * */
    @Scheduled(fixedDelay = "10s")
    void executeEveryTenSeconds() {
        LOG.info("Simple Job setiap 10 detik :{}", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
    }

    /*
    * Penjadwalan dengan jangka waktu yang pasti adalah 45  detik
    * namun saat aplikasi mulai berjalan, hitungan detik pertamanya adalah detik ke 6
    * artinya detik pertama hingga detik kelima tidak masuk hitungan karena ada "initialDelay = '5s'"
    * */
    @Scheduled(fixedDelay = "45s", initialDelay = "5s")
    void executeEveryFourtyFiveSeconds() {
        LOG.info("Simple Job setiap 45 detik - delay awal 5 detik :{}", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
    }
}
