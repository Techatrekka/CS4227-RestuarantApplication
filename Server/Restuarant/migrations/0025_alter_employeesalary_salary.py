# Generated by Django 3.2.9 on 2021-11-13 16:29

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('Restuarant', '0024_alter_employeesalary_salary'),
    ]

    operations = [
        migrations.AlterField(
            model_name='employeesalary',
            name='salary',
            field=models.DecimalField(decimal_places=2, max_digits=7),
        ),
    ]
