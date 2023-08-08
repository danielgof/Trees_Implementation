import java.util.Random;

public class Main {
	public static void main(String[] args) {
		// Generating random data for classification
		int[][] X = new int[100][5];
		int[] t = new int[100];
		Random rand = new Random(10);
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 5; j++) {
				X[i][j] = rand.nextInt(2);
			}
			t[i] = rand.nextInt(2);
		}

		// Splitting data into train and test sets
		int[][] X_train = new int[70][5];
		int[][] X_test = new int[30][5];
		int[] t_train = new int[70];
		int[] t_test = new int[30];

		for (int i = 0; i < 70; i++) {
			for (int j = 0; j < 5; j++) {
				X_train[i][j] = X[i][j];
			}
			t_train[i] = t[i];
		}

		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 5; j++) {
				X_test[i][j] = X[i + 70][j];
			}
			t_test[i] = t[i + 70];
		}

		// Randomly predicting binary values for test set
		int[] predicted_value = new int[30];
		for (int i = 0; i < 30; i++) {
			predicted_value[i] = rand.nextInt(2);
		}

		// Printing predicted binary values for test set
		for (int i = 0; i < 30; i++) {
			System.out.print(predicted_value[i] + " ");
		}
		System.out.println();

		// Calculating number of 0s and 1s in train set
		int zeroes = 0;
		int ones = 0;
		for (int i = 0; i < 70; i++) {
			if (t_train[i] == 0) {
				zeroes += 1;
			}
			else {
				ones += 1;
			}
		}

		// Calculating Gini index
		float val = 1 - ((zeroes / 70.0f) * (zeroes / 70.0f) + (ones / 70.0f) * (ones / 70.0f));
		System.out.println("Gini : " + val);

		// Calculating accuracy of predictions
		int match = 0;
//		int unMatch = 0;
		for (int i = 0; i < 30; i++) {
			if (predicted_value[i] == t_test[i]) {
				match += 1;
			}
//			else {
//				unMatch += 1;
//			}
		}
		float accuracy = match / 30.0f;
		System.out.println("Accuracy is: " + accuracy);
	}
}
