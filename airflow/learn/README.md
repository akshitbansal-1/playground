```
python3 -m venv py_env
source py_env/bin/activate
python3 --version

# check your python version and replace it in the constraints-[PYTHON_VERSION] part
# https://airflow.apache.org/docs/apache-airflow/stable/installation/installing-from-pypi.html
# if you have other versions installed which are not supported by airflow(check their site above), install the required version
# then create the env with new version, for e.g.
# /opt/homebrew/bin/python3.8 -m venv py_env
# the rest is same
pip install "apache-airflow[celery]==2.8.4" --constraint "https://raw.githubusercontent.com/apache/airflow/constraints-2.8.4/constraints-[PYTHON_VERSION].txt"

# change home directory for airflow, defaults to ~
export AIRFLOW_HOME="$(pwd)"

# create a user before we start
airflow users create --username admin --firstname akshit --lastname bansal --role Admin --email admin@example.org

# start a scheduler in another terminal, more on this later
airflow scheduler

# then start the server in another terminal
airflow webserver -p 8080
```