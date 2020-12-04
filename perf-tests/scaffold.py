# Python 3.9.0

import json
import random
import uuid
from builtins import open, str, range

TOTAL_FILES = 10
URL = "http://127.0.0.1:8080/payment-api/api/v1/payments"
HTTP_METHOD = "POST"


def get_file_name(number):
    return "request" + str(number) + ".json"


def request_body():
    return {
        'description': uuid.uuid4().__str__(),
        'option': random.choice(["CREDIT_CARD", "DEBIT_CARD"]),
        'price': random.uniform(0, 100),
        'quantity': random.randint(0, 100)
    }


# json files generation
with open("targets.raw", "w+") as targets:
    for i in range(TOTAL_FILES):
        entire_path = "payloads/" + get_file_name(i)
        with open(entire_path, "w+") as request:
            request.write(json.dumps(request_body()))
            request.close()

        targets.write(HTTP_METHOD + " " + URL + "\n")
        targets.write("Content-Type: application/json" + "\n")
        targets.write("@" + entire_path + "\n")
    targets.close()
