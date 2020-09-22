import subprocess


from flask import Flask, request

app = Flask(__name__)


@app.route("/flights")
def flights():
    return subprocess.check_output("java -classpath C:/Users/user2/eclipse-workspace/FlightSystem/bin Flight.Program",
                                   request.args.get('outformat'),
                                   request.args.get('kind'),
                                   request.args.get('city'),
                                   request.args.get('company'),
                                   request.args.get('year'),
                                   request.args.get('month'),
                                   request.args.get('fromDay'),
                                   request.args.get('toYear'),
                                   request.args.get('toMonth'),
                                   request.args.get('toDay'),
                                   request.args.get('dayInWeek')
                                   )


app.run(port=8002, host="0.0.0.0")
