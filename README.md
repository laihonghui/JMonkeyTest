# Java Monkey Test
A library that can be used to perform a "monkey" test, which generates random values to test the behaviour of classes and methods.

## Getting Started
Just import the lib into your project

### Prerequisites
Something you wish to test
## Implementation to your project
Either take a look at the Testing.java file or read along
First initialize a new monkey test.
```
MonkeyBase test1 = new MonkeyBase("TESTNAME", ITERATIONS);
```
Where testname will be the logged testname and iterations is the amount of times we provide random input.
Then setup a for loop with the method inside
```
	public static void main(String[] args) {
		MonkeyBase test1 = new MonkeyBase("test1", 20000);
		for (int i = 0; i <= 20000; i++) {
			test(test1.randomString(), test1.randomInt());
		}
	}
	
	public static void test(String test2, int test1) {
		//Somemethod in here that utilizes the two paramaters
	}
```

A log txt file will be added to your source folder containing intresting information about the test.
## Authors

* **Mathias Thejsen** - thejsen@live.dk

## License

This project is licensed under the MIT License.


