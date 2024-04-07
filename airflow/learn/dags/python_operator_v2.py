from airflow import DAG
from airflow.operators.python import PythonOperator
from datetime import datetime, timedelta

default_args = {
    'owner': 'akshit',
    'retries': 2,
    'retry_delay': timedelta(minutes=2)
}

def greet(ti):
    ti.xcom_push(key='name', value='Akshit')
    ti.xcom_push(key='age', value=25)

def greetV2(ti):
    name = ti.xcom_pull(task_ids ='Greet', key='name')
    age = ti.xcom_pull(task_ids ='Greet', key='age')
    print(f'Hi {name}, I am {age} years old')

with DAG(
    dag_id='python_opeator_v2',
    description='Python operator DAG with xcom',
    start_date=datetime(2024, 4, 1),
    schedule_interval='@daily',
    default_args=default_args,
    catchup=True
) as dag:
    
    task1 = PythonOperator(
        task_id = 'Greet',
        python_callable=greet
    )

    task2 = PythonOperator(
        task_id = 'custom_greet',
        python_callable=greetV2,
        op_kwargs={ 'age': 25 }
    )


    task1 >> task2