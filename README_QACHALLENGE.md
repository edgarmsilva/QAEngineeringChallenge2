# BellSant Machine Health Tests

## Test Scenarios for the API:

For the Calculate Tests I separated the test in two groups:
* one for a specific Machine Part of each machine, which I chose as an important part for the machine
* another group for each part of each machine

I also created a regression Test to assure that all machine parts meets the normal range values and health score of 100


### Problems Found:

*   Machine: Quality Control Station: 

The configuration for the Software Version has characters on the values and it is interferieng on the final health score

```
"softwareVersion": {
      "normalRange": ["v1.0", "v2.0"],
      "abnormalRange": ["v2.1", "v3.0"],
      "optimalRange": ["v1.0", "v2.0"]
    },
```

## Test Scenarios for the Mobile App:


