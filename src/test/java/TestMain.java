import me.brennan.textverified.TextVerified;
import me.brennan.textverified.model.Target;
import me.brennan.textverified.model.Verification;

import java.util.concurrent.TimeUnit;

/**
 * @author Brennan
 * @since 10/24/2021
 **/
public class TestMain {

    public static void main(String[] args) throws Exception {
        TextVerified textVerified = new TextVerified("CLIENT_KEY", "CLIENT_SECRET");

        final Target discordTarget = textVerified.getTarget(19);
        System.out.println("Target: " + discordTarget.getName() + " Cost: $" + discordTarget.getCost());

        final Verification verification = textVerified.createVerification(discordTarget);

        if (verification != null) {
            System.out.println(verification.getNumber());
            System.out.println(verification.getId());

            while (true) {
                Verification verificationGet = textVerified.getVerification(verification.getId());

                System.out.println();
                System.out.println(verificationGet.getStatus());
                System.out.println(verificationGet.getSms());
                System.out.println(verificationGet.getCode());
                System.out.println();
                TimeUnit.SECONDS.sleep(3);
            }
        }
    }
}
