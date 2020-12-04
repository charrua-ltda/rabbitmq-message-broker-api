# Performance Tests

## Requirements

* [Vegeta](https://github.com/tsenart/vegeta#install)
* [Python 3.9] (https://github.com/pyenv/pyenv)

## Description

This directory contains all the files used on the performance test execution. Vegeta was the tool used to run tests, due
to its simplicity, flexibility, and robustness.

The payloads and targets are being generated on the scaffold.py.

## Generating Test Data

The python script below will do the trick.

```
$ python scaffold.py
```

The data will be generated under the payloads directory and in the targets.raw file.

Of course, the script could be enhanced to create different paylods and targets.

## Running

The following command is going to run a test for 100s with a 50 req/s rate. It is going to generate also a report with
the current timestamp under the reports directory.

```
$ vegeta attack -duration=10s -rate=10 --targets=targets.raw | vegeta report --type=text >> "reports/$(date +%s).raw"
$ cat reports/"$(ls -1rt reports | tail -n1)" 
```