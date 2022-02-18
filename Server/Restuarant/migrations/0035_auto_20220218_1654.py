# Generated by Django 3.2.9 on 2022-02-18 16:54

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('Restuarant', '0034_beverages_description'),
    ]

    operations = [
        migrations.CreateModel(
            name='StockItems',
            fields=[
                ('stock_item_id', models.AutoField(primary_key=True, serialize=False)),
                ('name', models.CharField(max_length=500)),
                ('count', models.IntegerField()),
                ('expiry_date', models.DateField()),
                ('allergens', models.CharField(max_length=500)),
                ('isFood', models.BooleanField()),
            ],
        ),
        migrations.DeleteModel(
            name='Beverages',
        ),
        migrations.RemoveField(
            model_name='dishes_fooditems',
            name='dish_id',
        ),
        migrations.RemoveField(
            model_name='dishes_fooditems',
            name='food_id',
        ),
        migrations.DeleteModel(
            name='DrinkItems',
        ),
        migrations.RenameField(
            model_name='menuitem',
            old_name='food',
            new_name='Alcoholic',
        ),
        migrations.RenameField(
            model_name='orderlineitems',
            old_name='order_id',
            new_name='Order_id',
        ),
        migrations.RenameField(
            model_name='orderlineitems',
            old_name='orderlineitems_id',
            new_name='line_item',
        ),
        migrations.RemoveField(
            model_name='menuitem',
            name='dish_bev_id',
        ),
        migrations.RemoveField(
            model_name='menuitem',
            name='menu_id',
        ),
        migrations.RemoveField(
            model_name='orderlineitems',
            name='food',
        ),
        migrations.AddField(
            model_name='menuitem',
            name='Description',
            field=models.CharField(default=1, max_length=500),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='menuitem',
            name='Ingredients',
            field=models.CharField(default=1, max_length=500),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='menuitem',
            name='Price',
            field=models.DecimalField(decimal_places=2, default=0, max_digits=5),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='menuitem',
            name='isFood',
            field=models.BooleanField(default=False),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='menuitem',
            name='name',
            field=models.CharField(default='Food', max_length=500),
            preserve_default=False,
        ),
        migrations.AlterField(
            model_name='orderlineitems',
            name='menu_item',
            field=models.IntegerField(),
        ),
        migrations.DeleteModel(
            name='Dishes',
        ),
        migrations.DeleteModel(
            name='Dishes_FoodItems',
        ),
        migrations.DeleteModel(
            name='FoodItems',
        ),
    ]
