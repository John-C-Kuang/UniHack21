package Person;

import java.util.ArrayList;
import java.util.Arrays;

public class Reference {
  public static final ArrayList<Float> PR_POS_SYMPTOMS = new ArrayList<Float>(Arrays.asList(74.2f,
      58.3f, 56.7f, 45.0f, 34.2f, 31.7f, 30.0f, 29.2f, 28.3f, 27.5f, 23.3f, 21.7f, 19.2f, 15.8f));
  public static final ArrayList<Float> PR_NEG_SYMPTOMS = new ArrayList<Float>(Arrays.asList(65.8f,
      60.0f, 48.3f, 43.3f, 5.8f, 39.2f, 6.7f, 25.0f, 16.7f, 31.7f, 20.0f, 21.7f, 14.2f, 21.7f));
  public static final float PR_POS_CONFIRM = 25.8f / (25.8f + 14.2f);
  public static final float PR_NEG_CONFIRM = 1 - PR_POS_CONFIRM;
  public static final float PR_POS_POSSIBLE = 15.0f / (15.0f + 14.2f);
  public static final float PR_NEG_POSSIBLE = 1 - PR_POS_POSSIBLE;
  public static final float VACC_EFFICIENCY = 0.79f;
}
