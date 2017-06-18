package com.database.utilities;

import java.sql.Connection;
import java.sql.Statement;

import com.vso.interfaces.DatabaseNames;
import com.vso.interfaces.TablesColumnNames;;

public class FillTables implements DatabaseNames, TablesColumnNames {
	SetupDB single = SetupDB.getInstance();
	private Statement dbStatement = SetupDB.getStatement();

	public FillTables() {
		fillProductsTable();
	}

	private void fillProductsTable() {
		try {
			String product1 = tableProductsInsertCommand
					+ "'Боб', 'Бобови храни', '333', '1', '23', '60', 'гр.', 'веган');";
			System.out.println(product1);
			dbStatement.executeUpdate(product1);
			String product2 = tableProductsInsertCommand
					+ "'Тофу', 'Бобови храни', '77', '4', '8', '3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product2);
			String product3 = tableProductsInsertCommand
					+ "'Червен боб', 'Бобови храни', '333', '1', '24', '60', 'гр.', 'веган');";
			dbStatement.executeUpdate(product3);
			String product4 = tableProductsInsertCommand
					+ "'Червена леща', 'Бобови храни', '346', '2', '25', '59', 'гр.', 'веган');";
			dbStatement.executeUpdate(product4);
			String product5 = tableProductsInsertCommand
					+ "'Гъби', 'Гъби', '13.5', '0.5', '1.8', '0.4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product5);
			String product6 = tableProductsInsertCommand
					+ "'Гъби консерва', 'Гъби', '80', '5', '3.4', '5.4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product6);
			String product7 = tableProductsInsertCommand + "'Печурки', 'Гъби', '25', '0', '3', '4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product7);
			String product8 = tableProductsInsertCommand + "'Кладница', 'Гъби', '25', '0', '3', '4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product8);
			String product9 = tableProductsInsertCommand
					+ "'Манатарки', 'Гъби', '13.5', '0.5', '1.8', '0.4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product9);
			String product10 = tableProductsInsertCommand
					+ "'Сушени гъби', 'гъби', '296', '1', '10', '75', 'гр.', 'веган');";
			dbStatement.executeUpdate(product10);
			String product11 = tableProductsInsertCommand + "'Вода', 'Други', '0', '0', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product11);
			String product12 = tableProductsInsertCommand
					+ "'Коктейлна черешка', 'Захарни изделия', '165', '0', '0', '42', 'гр.', 'веган');";
			dbStatement.executeUpdate(product12);
			String product13 = tableProductsInsertCommand + "'Лед', 'други', '0', '0', '0', '0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product13);
			String product14 = tableProductsInsertCommand
					+ "'Бял шоколад', 'Захарни изделия', '526', '43', '3', '45', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product14);
			String product15 = tableProductsInsertCommand
					+ "'Ванилов сладолед', 'Захарни изделия', '201', '11', '4', '24', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product15);
			String product16 = tableProductsInsertCommand
					+ "'Вафла', 'Захарни изделия', '524', '27.5', '7.5', '59.5', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product16);
			String product17 = tableProductsInsertCommand
					+ "'Глюкоза', 'Захарни изделия', '387', '0', '0', '100', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product17);
			String product18 = tableProductsInsertCommand
					+ "'Еклер', 'Захарни изделия', '262', '16', '6', '24', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product18);
			String product19 = tableProductsInsertCommand
					+ "'Захар', 'Захарни изделия', '409', '0.0', '0.0', '99.9', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product19);
			String product20 = tableProductsInsertCommand
					+ "'Захарен сироп', 'Захарни изделия', '193', '0', '0', '50', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product20);
			String product21 = tableProductsInsertCommand
					+ "'Кроасан', 'Захарни изделия', '406', '21', '8', '46', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product21);
			String product22 = tableProductsInsertCommand
					+ "'Мармалад', 'Захарни изделия', '278', '0', '0', '69', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product22);
			String product23 = tableProductsInsertCommand
					+ "'Млечен шоколад', 'Захарни изделия', '513', '31', '7', '59', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product23);
			String product24 = tableProductsInsertCommand
					+ "'Пудра захар', 'Захарни изделия', '389', '0', '0', '100', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product24);
			String product25 = tableProductsInsertCommand
					+ "'Топинг', 'Захарни изделия', '287', '0', '0', '76', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product25);
			String product26 = tableProductsInsertCommand
					+ "'Халва', 'Захарни изделия', '469', '22', '12', '60', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product26);
			String product27 = tableProductsInsertCommand
					+ "'Целувки', 'Захарни изделия', '285', '13', '4', '39', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product27);
			String product28 = tableProductsInsertCommand
					+ "'Шоколад', 'Захарни изделия', '505', '34', '4', '60', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product28);
			String product29 = tableProductsInsertCommand
					+ "'Шоколад  85%', 'Захарни изделия', '541', '46.0', '11.0', '19.0', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product29);
			String product30 = tableProductsInsertCommand
					+ "'Шоколад 45 %', 'Захарни изделия', '518', '31.3', '5.2', '51.9', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product30);
			String product31 = tableProductsInsertCommand
					+ "'Шоколад 70%', 'Захарни изделия', '532', '40.0', '8.0', '33.0', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product31);
			String product32 = tableProductsInsertCommand
					+ "'Шоколад 99%', 'Захарни изделия', '532', '49.0', '13.0', '8.0', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product32);
			String product33 = tableProductsInsertCommand
					+ "'Шоколадов сладолед', 'Захарни изделия', '216', '11', '4', '28', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product33);
			String product34 = tableProductsInsertCommand
					+ "'Ягодов сладолед', 'Захарни изделия', '192', '8', '3', '28', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product34);
			String product35 = tableProductsInsertCommand
					+ "'Алабаш', 'Зеленчуци', '27', '0', '2', '6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product35);
			String product36 = tableProductsInsertCommand
					+ "'Артишок', 'Зеленчуци', '57', '0.1', '2.4', '11.4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product36);
			String product37 = tableProductsInsertCommand
					+ "'Бамбук', 'Зеленчуци', '27', '0', '3', '5', 'гр.', 'веган');";
			dbStatement.executeUpdate(product37);
			String product38 = tableProductsInsertCommand
					+ "'Бейби моркови', 'Зеленчуци', '38', '1', '1', '8', 'гр.', 'веган');";
			dbStatement.executeUpdate(product38);
			String product39 = tableProductsInsertCommand
					+ "'Броколи', 'Зеленчуци', '33', '1', '4.4', '1.8', 'гр.', 'веган');";
			dbStatement.executeUpdate(product39);
			String product40 = tableProductsInsertCommand
					+ "'Брюкселско зеле', 'Зеленчуци', '42', '0', '5', '4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product40);
			String product41 = tableProductsInsertCommand
					+ "'Дайкон', 'Зеленчуци', '27', '0', '1', '6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product41);
			String product42 = tableProductsInsertCommand
					+ "'Доматен сок', 'Зеленчуци', '17', '0', '1', '4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product42);
			String product43 = tableProductsInsertCommand
					+ "'Доматен сос', 'Зеленчуци', '33', '0', '1', '7', 'гр.', 'веган');";
			dbStatement.executeUpdate(product43);
			String product44 = tableProductsInsertCommand
					+ "'Доматена супа', 'Зеленчуци', '73', '0', '2', '16', 'гр.', 'веган');";
			dbStatement.executeUpdate(product44);
			String product45 = tableProductsInsertCommand
					+ "'Доматено пюре', 'Зеленчуци', '40', '0', '2', '10', 'гр.', 'веган');";
			dbStatement.executeUpdate(product45);
			String product46 = tableProductsInsertCommand
					+ "'Домати', 'Зеленчуци', '23', '0.2', '1.0', '4.2', 'гр.', 'веган');";
			dbStatement.executeUpdate(product46);
			String product47 = tableProductsInsertCommand
					+ "'Зеле - китайско', 'Зеленчуци', '19', '0.2', '1.2', '3.2', 'гр.', 'веган');";
			dbStatement.executeUpdate(product47);
			String product48 = tableProductsInsertCommand
					+ "'Зеле - червено', 'Зеленчуци', '37', '0.2', '1.4', '7.4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product48);
			String product49 = tableProductsInsertCommand
					+ "'Камби', 'Зеленчуци', '25', '0.3', '1.0', '4.6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product49);
			String product50 = tableProductsInsertCommand
					+ "'Картоф', 'зеленчуци', '77', '0', '2', '17', 'гр.', 'веган');";
			dbStatement.executeUpdate(product50);
			String product51 = tableProductsInsertCommand
					+ "'Картофено пюре', 'зеленчуци', '79', '2', '2', '13', 'гр.', 'веган');";
			dbStatement.executeUpdate(product51);
			String product52 = tableProductsInsertCommand
					+ "'Картофи', 'Зеленчуци', '80', '0.1', '2.0', '17.5', 'гр.', 'веган');";
			dbStatement.executeUpdate(product52);
			String product53 = tableProductsInsertCommand
					+ "'Киселец', 'зеленчуци', '23', '1', '2', '4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product53);
			String product54 = tableProductsInsertCommand
					+ "'Кисело зеле', 'Зеленчуци', '30', '0.3', '1.5', '5.3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product54);
			String product55 = tableProductsInsertCommand
					+ "'Китайско зеле', 'зеленчуци', '13', '0', '2', '2', 'гр.', 'веган');";
			dbStatement.executeUpdate(product55);
			String product56 = tableProductsInsertCommand
					+ "'Коприва', 'зеленчуци', '42', '0', '3', '7', 'гр.', 'веган');";
			dbStatement.executeUpdate(product56);
			String product57 = tableProductsInsertCommand
					+ "'Краставици', 'Зеленчуци', '13', '0.2', '0.6', '2.3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product57);
			String product58 = tableProductsInsertCommand
					+ "'Къдраво зеле', 'зеленчуци', '50', '1', '3', '10', 'гр.', 'веган');";
			dbStatement.executeUpdate(product58);
			String product59 = tableProductsInsertCommand
					+ "'Кълнове', 'зеленчуци', '122', '7', '13', '10', 'гр.', 'веган');";
			dbStatement.executeUpdate(product59);
			String product60 = tableProductsInsertCommand
					+ "'Кълнове от пшеница', 'зеленчуци', '216', '1.3', '7.5', '42.5', 'гр.', 'веган');";
			dbStatement.executeUpdate(product60);
			String product61 = tableProductsInsertCommand
					+ "'Лапад', 'зеленчуци', '22', '1', '2', '3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product61);
			String product62 = tableProductsInsertCommand
					+ "'Лозови листа', 'зеленчуци', '93', '2', '6', '17', 'гр.', 'веган');";
			dbStatement.executeUpdate(product62);
			String product63 = tableProductsInsertCommand + "'Лук', 'зеленчуци', '38', '0', '1', '9', 'гр.', 'веган');";
			dbStatement.executeUpdate(product63);
			String product64 = tableProductsInsertCommand
					+ "'Лук зелен', 'Зеленчуци', '26', '0.2', '1.8', '4.3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product64);
			String product65 = tableProductsInsertCommand
					+ "'Люта чушка', 'зеленчуци', '40', '0', '2', '9', 'гр.', 'веган');";
			dbStatement.executeUpdate(product65);
			String product66 = tableProductsInsertCommand
					+ "'Мариновани краставички', 'зеленчуци', '11', '0', '0', '2', 'гр.', 'веган');";
			dbStatement.executeUpdate(product66);
			String product67 = tableProductsInsertCommand
					+ "'Маслина', 'зеленчуци', '115', '11', '1', '6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product67);
			String product68 = tableProductsInsertCommand
					+ "'Маслини - зелени', 'зеленчуци', '158', '15.3', '1.0', '3.8', 'гр.', 'веган');";
			dbStatement.executeUpdate(product68);
			String product69 = tableProductsInsertCommand
					+ "'Маслини - зрели джъмбо', 'зеленчуци', '89', '6.9', '1.0', '5.6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product69);
			String product70 = tableProductsInsertCommand
					+ "'Маслини - класик', 'зеленчуци', '126', '10.7', '0.8', '6.3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product70);
			String product71 = tableProductsInsertCommand
					+ "'Морков', 'зеленчуци', '43', '0', '1', '10', 'гр.', 'веган');";
			dbStatement.executeUpdate(product71);
			String product72 = tableProductsInsertCommand
					+ "'Пресен лук', 'зеленчуци', '32', '0', '2', '7', 'гр.', 'веган');";
			dbStatement.executeUpdate(product72);
			String product73 = tableProductsInsertCommand
					+ "'Репичка', 'зеленчуци', '20', '1', '1', '4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product73);
			String product74 = tableProductsInsertCommand
					+ "'Ряпа', 'Зеленчуци', '37', '0.1', '1.9', '7.0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product74);
			String product75 = tableProductsInsertCommand
					+ "'Салата айсберг', 'зеленчуци', '12', '0', '1', '2', 'гр.', 'веган');";
			dbStatement.executeUpdate(product75);
			String product76 = tableProductsInsertCommand
					+ "'Соеви кълнове', 'зеленчуци', '122', '7', '13', '10', 'гр.', 'веган');";
			dbStatement.executeUpdate(product76);
			String product77 = tableProductsInsertCommand
					+ "'Сок от моркови', 'зеленчуци', '40', '0', '1', '9', 'гр.', 'веган');";
			dbStatement.executeUpdate(product77);
			String product78 = tableProductsInsertCommand
					+ "'Сушени домати', 'зеленчуци', '258', '3', '14', '56', 'гр.', 'веган');";
			dbStatement.executeUpdate(product78);
			String product79 = tableProductsInsertCommand
					+ "'Сушени чушки', 'зеленчуци', '314', '3', '18', '69', 'гр.', 'веган');";
			dbStatement.executeUpdate(product79);
			String product80 = tableProductsInsertCommand
					+ "'Тиквички', 'Зеленчуци', '17', '0.0', '0.6', '3.7', 'гр.', 'веган');";
			dbStatement.executeUpdate(product80);
			String product81 = tableProductsInsertCommand
					+ "'Фасул зелен', 'Зеленчуци', '33', '0.3', '2.2', '5.3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product81);
			String product82 = tableProductsInsertCommand
					+ "'Цвекло', 'зеленчуци', '43', '0', '2', '10', 'гр.', 'веган');";
			dbStatement.executeUpdate(product82);
			String product83 = tableProductsInsertCommand
					+ "'Цвекло червено', 'Зеленчуци', '43', '0.1', '1.2', '9.3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product83);
			String product84 = tableProductsInsertCommand
					+ "'Целина', 'зеленчуци', '16', '0', '1', '4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product84);
			String product85 = tableProductsInsertCommand
					+ "'Червена маруля', 'зеленчуци', '18', '0', '1', '4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product85);
			String product86 = tableProductsInsertCommand
					+ "'Червено зеле', 'зеленчуци', '27', '0', '1', '6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product86);
			String product87 = tableProductsInsertCommand
					+ "'Чушка', 'Зеленчуци', '31', '0.3', '1.0', '6.0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product87);
			String product88 = tableProductsInsertCommand
					+ "'Зрял боб', 'Бобови храни', '113', '1', '7', '20', 'гр.', 'веган');";
			dbStatement.executeUpdate(product88);
			String product89 = tableProductsInsertCommand
					+ "'Кафяв ориз', 'Хлебни изделия и зърнени храни', '362', '3', '8', '76 (3 ф)', 'гр.', 'веган');";
			dbStatement.executeUpdate(product89);
			String product90 = tableProductsInsertCommand
					+ "'Леща', 'Бобови храни', '105', '0.7', '8.8', '17', 'гр.', 'веган');";
			dbStatement.executeUpdate(product90);
			String product91 = tableProductsInsertCommand
					+ "'Амарето', 'ликьор', '357', '6', '3', '46', 'мл.', 'веган');";
			dbStatement.executeUpdate(product91);
			String product92 = tableProductsInsertCommand
					+ "'Бейлис', 'ликьор', '327', '16', '3', '21', 'мл.', 'веган');";
			dbStatement.executeUpdate(product92);
			String product93 = tableProductsInsertCommand
					+ "'Калуа', 'ликьор', '327', '16', '3', '21', 'мл.', 'веган');";
			dbStatement.executeUpdate(product93);
			String product94 = tableProductsInsertCommand
					+ "'Ликьор', 'ликьор', '314', '0', '0', '35', 'мл.', 'веган');";
			dbStatement.executeUpdate(product94);
			String product95 = tableProductsInsertCommand
					+ "'Ликьор (30% алк)', 'ликьор', '368', '0', '0', '39', 'мл.', 'веган');";
			dbStatement.executeUpdate(product95);
			String product96 = tableProductsInsertCommand
					+ "'Ликьор кафе', 'ликьор', '336', '0', '0', '47', 'мл.', 'веган');";
			dbStatement.executeUpdate(product96);
			String product97 = tableProductsInsertCommand
					+ "'Ликьор кюрасо', 'ликьор', '397', '0', '0', '32', 'мл.', 'веган');";
			dbStatement.executeUpdate(product97);
			String product98 = tableProductsInsertCommand
					+ "'Ликьор от праскови', 'ликьор', '402', '0', '0', '39', 'мл.', 'веган');";
			dbStatement.executeUpdate(product98);
			String product99 = tableProductsInsertCommand
					+ "'Ликьор синьо кюрасо', 'ликьор', '397', '0', '0', '32', 'мл.', 'веган');";
			dbStatement.executeUpdate(product99);
			String product100 = tableProductsInsertCommand
					+ "'Портокалов ликьор', 'ликьор', '382', '0', '0', '35', 'мл.', 'веган');";
			dbStatement.executeUpdate(product100);
			String product101 = tableProductsInsertCommand
					+ "'Маргарин', 'мазнина', '722', '79.4', '0.0', '0.0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product101);
			String product102 = tableProductsInsertCommand
					+ "'Масло от авокадо', 'мазнина', '900', '99.0', '0.0', '0.0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product102);
			String product103 = tableProductsInsertCommand
					+ "'Масло от бадем', 'мазнина', '900', '99.0', '0.0', '0.0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product103);
			String product104 = tableProductsInsertCommand
					+ "'Масло от какао', 'мазнина', '900', '99.0', '0.0', '0.0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product104);
			String product105 = tableProductsInsertCommand
					+ "'Масло от кокос', 'мазнина', '900', '99.0', '0.0', '0.0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product105);
			String product106 = tableProductsInsertCommand
					+ "'Масло от овес', 'мазнина', '900', '99.0', '0.0', '0.0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product106);
			String product107 = tableProductsInsertCommand
					+ "'Масло от сусам', 'мазнина', '900', '99.0', '0.0', '0.0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product107);
			String product108 = tableProductsInsertCommand
					+ "'Олио', 'мазнина', '884', '100', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product108);
			String product109 = tableProductsInsertCommand
					+ "'Олио - слънчогледово', 'мазнина', '909', '99.9', '0.0', '0.0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product109);
			String product110 = tableProductsInsertCommand
					+ "'Олио - соево', 'мазнина', '900', '99.0', '0.0', '0.0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product110);
			String product111 = tableProductsInsertCommand
					+ "'Палмово масло', 'мазнина', '884', '100', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product111);
			String product112 = tableProductsInsertCommand
					+ "'Сусамово масло', 'мазнина', '592', '53', '17', '22', 'мл.', 'веган');";
			dbStatement.executeUpdate(product112);
			String product113 = tableProductsInsertCommand
					+ "'Сусамово олио', 'мазнина', '884', '100', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product113);
			String product114 = tableProductsInsertCommand
					+ "'Зехтин', 'мазнина', '884', '100', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product114);
			String product115 = tableProductsInsertCommand
					+ "'Краве масло', 'мазнина', '717', '81', '1', '0', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product115);
			String product116 = tableProductsInsertCommand
					+ "'Ленено семе смляно 1с.л.', 'подправки', '37', '3', '1', '2 (2ф)', 'гр.', 'веган');";
			dbStatement.executeUpdate(product116);
			String product117 = tableProductsInsertCommand
					+ "'Маслини', 'зеленчуци', '115', '11', '1', '6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product117);
			String product118 = tableProductsInsertCommand
					+ "'Сусам', 'Хлебни изделия и зърнени храни', '573', '50', '18', '23 (12ф)', 'гр.', 'веган');";
			dbStatement.executeUpdate(product118);
			String product119 = tableProductsInsertCommand
					+ "'Сусамов тахан 1 с.л.', 'Хлебни изделия и зърнени храни', '85', '8', '3', '3 (1ф)', 'гр.', 'веган');";
			dbStatement.executeUpdate(product119);
			String product120 = tableProductsInsertCommand
					+ "'Фъстъчено масло', 'мазнина', '588', '50', '25', '20', 'гр.', 'веган');";
			dbStatement.executeUpdate(product120);
			String product121 = tableProductsInsertCommand
					+ "'Агнешка плешка', 'Месо, месни продукти', '264', '21', '17', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product121);
			String product122 = tableProductsInsertCommand
					+ "'Агнешки бут', 'Месо, месни продукти', '266', '18', '26', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product122);
			String product123 = tableProductsInsertCommand
					+ "'Агнешки врат', 'Месо, месни продукти', '315', '22', '16', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product123);
			String product124 = tableProductsInsertCommand
					+ "'Агнешки котлет', 'Месо, месни продукти', '386', '37', '15', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product124);
			String product125 = tableProductsInsertCommand
					+ "'Агнешко', 'Месо, месни продукти', '178', '11.7', '17.5', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product125);
			String product126 = tableProductsInsertCommand
					+ "'Агнешко месо', 'Месо, месни продукти', '267', '22', '17', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product126);
			String product127 = tableProductsInsertCommand
					+ "'Агнешко месо (без мазнината)', 'Месо, месни продукти', '134', '5', '20', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product127);
			String product128 = tableProductsInsertCommand
					+ "'Агнешко/гърди', 'Месо, месни продукти', '380', '34', '17', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product128);
			String product129 = tableProductsInsertCommand
					+ "'Агнешко/каре', 'Месо, месни продукти', '377', '36', '15', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product129);
			String product130 = tableProductsInsertCommand
					+ "'Бекон', 'Месо, месни продукти', '414', '40', '14', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product130);
			String product131 = tableProductsInsertCommand
					+ "'Говеждо месо', 'Месо, месни продукти', '150', '7', '21', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product131);
			String product132 = tableProductsInsertCommand
					+ "'Говеждо месо от филе', 'Месо, месни продукти', '148', '7.8', '19.0', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product132);
			String product133 = tableProductsInsertCommand
					+ "'Гъски', 'Месо, месни продукти', '370', '29.7', '24.5', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product133);
			String product134 = tableProductsInsertCommand
					+ "'Гъши дроб', 'Месо, месни продукти', '133', '4', '16', '6', 'гр.', 'общо');";
			dbStatement.executeUpdate(product134);
			String product135 = tableProductsInsertCommand
					+ "'Език', 'Месо, месни продукти', '211', '15.9', '16.0', '0.4', 'гр.', 'общо');";
			dbStatement.executeUpdate(product135);
			String product136 = tableProductsInsertCommand
					+ "'Език, телешки', 'Месо, месни продукти', '224', '16', '15', '4', 'гр.', 'общо');";
			dbStatement.executeUpdate(product136);
			String product137 = tableProductsInsertCommand
					+ "'Желатин', 'Месо, месни продукти', '335', '0', '86', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product137);
			String product138 = tableProductsInsertCommand
					+ "'Заек', 'Месо, месни продукти', '136', '6', '20', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product138);
			String product139 = tableProductsInsertCommand
					+ "'Заешко', 'Месо, месни продукти', '124', '4', '21', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product139);
			String product140 = tableProductsInsertCommand
					+ "'Кайма', 'Месо, месни продукти', '263', '21', '17', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product140);
			String product141 = tableProductsInsertCommand
					+ "'Кокоше', 'Месо, месни продукти', '261', '20.8', '17.7', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product141);
			String product142 = tableProductsInsertCommand
					+ "'Кренвирш', 'Месо, месни продукти', '271', '21.5', '18.5', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product142);
			String product143 = tableProductsInsertCommand
					+ "'Кървавица', 'Месо, месни продукти', '378', '34', '15', '1', 'гр.', 'общо');";
			dbStatement.executeUpdate(product143);
			String product144 = tableProductsInsertCommand
					+ "'Луканка', 'Месо, месни продукти', '460', '40', '25', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product144);
			String product145 = tableProductsInsertCommand
					+ "'Мозък', 'Месо, месни продукти', '130', '9.6', '10.4', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product145);
			String product146 = tableProductsInsertCommand
					+ "'Наденица', 'Месо, месни продукти', '230', '17', '15', '3', 'гр.', 'общо');";
			dbStatement.executeUpdate(product146);
			String product147 = tableProductsInsertCommand
					+ "'Овче', 'Месо, месни продукти', '188', '12.5', '18.2', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product147);
			String product148 = tableProductsInsertCommand
					+ "'Пастет', 'Месо, месни продукти', '462', '44', '11', '5', 'гр.', 'общо');";
			dbStatement.executeUpdate(product148);
			String product149 = tableProductsInsertCommand
					+ "'Патешки дроб', 'Месо, месни продукти', '136', '5', '19', '4', 'гр.', 'общо');";
			dbStatement.executeUpdate(product149);
			String product150 = tableProductsInsertCommand
					+ "'Патешки шийки', 'Месо, месни продукти', '68', '2', '11', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product150);
			String product151 = tableProductsInsertCommand
					+ "'Петли', 'Месо, месни продукти', '148', '7.0', '20.8', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product151);
			String product152 = tableProductsInsertCommand
					+ "'Пиле', 'Месо, месни продукти', '215', '15', '19', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product152);
			String product153 = tableProductsInsertCommand
					+ "'Пилешка кожа от ½ пиле', 'Месо, месни продукти', '276', '26', '11', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product153);
			String product154 = tableProductsInsertCommand
					+ "'Пилешки воденици', 'Месо, месни продукти', '118', '4', '18', '1', 'гр.', 'общо');";
			dbStatement.executeUpdate(product154);
			String product155 = tableProductsInsertCommand
					+ "'Пилешки гърди', 'Месо, месни продукти', '114', '2', '23', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product155);
			String product156 = tableProductsInsertCommand
					+ "'Пилешки дробчета', 'Месо, месни продукти', '119', '5', '17', '1', 'гр.', 'общо');";
			dbStatement.executeUpdate(product156);
			String product157 = tableProductsInsertCommand
					+ "'Пилешки крила', 'Месо, месни продукти', '214', '15.0', '18.0', '1.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product157);
			String product158 = tableProductsInsertCommand
					+ "'Пилешки крилца', 'Месо, месни продукти', '222', '16', '18', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product158);
			String product159 = tableProductsInsertCommand
					+ "'Пилешки сърца', 'Месо, месни продукти', '153', '9', '15', '1', 'гр.', 'общо');";
			dbStatement.executeUpdate(product159);
			String product160 = tableProductsInsertCommand
					+ "'Пилешко бутче', 'Месо, месни продукти', '119', '3', '21', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product160);
			String product161 = tableProductsInsertCommand
					+ "'Пилешко крило (без кости) 1 бр', 'Месо, месни продукти', '109', '8', '9', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product161);
			String product162 = tableProductsInsertCommand
					+ "'Пилешко месо', 'Месо, месни продукти', '111', '3', '20', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product162);
			String product163 = tableProductsInsertCommand
					+ "'Пилешко месо от бут', 'Месо, месни продукти', '117', '3.4', '21.0', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product163);
			String product164 = tableProductsInsertCommand
					+ "'Пилешко месо от бутче', 'Месо, месни продукти', '125', '4', '20', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product164);
			String product165 = tableProductsInsertCommand
					+ "'Пилешко месо от гърди', 'Месо, месни продукти', '109', '1.2', '24.0', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product165);
			String product166 = tableProductsInsertCommand
					+ "'Пилешко месо от плешка', 'Месо, месни продукти', '133', '5.9', '19.5', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product166);
			String product167 = tableProductsInsertCommand
					+ "'Пилешко месо/бутче', 'Месо, месни продукти', '119', '4', '20', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product167);
			String product168 = tableProductsInsertCommand
					+ "'Пилешко месо/гърди', 'Месо, месни продукти', '110', '1', '23', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product168);
			String product169 = tableProductsInsertCommand
					+ "'Прошуто', 'Месо, месни продукти', '260', '18', '25', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product169);
			String product170 = tableProductsInsertCommand
					+ "'Пуешки воденички', 'Месо, месни продукти', '117', '4', '19', '1', 'гр.', 'общо');";
			dbStatement.executeUpdate(product170);
			String product171 = tableProductsInsertCommand
					+ "'Пуешки дроб', 'Месо, месни продукти', '137', '4', '20', '4', 'гр.', 'общо');";
			dbStatement.executeUpdate(product171);
			String product172 = tableProductsInsertCommand
					+ "'Пуешко бутче', 'Месо, месни продукти', '144', '7', '20', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product172);
			String product173 = tableProductsInsertCommand
					+ "'Пуешко месо', 'Месо, месни продукти', '115', '2', '24', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product173);
			String product174 = tableProductsInsertCommand
					+ "'Пуешко месо от бут', 'Месо, месни продукти', '105', '2.4', '20.3', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product174);
			String product175 = tableProductsInsertCommand
					+ "'Пуешко месо от гърди', 'Месо, месни продукти', '107', '0.7', '24.6', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product175);
			String product176 = tableProductsInsertCommand
					+ "'Пуешко месо от плешка', 'Месо, месни продукти', '116', '3.5', '20.7', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product176);
			String product177 = tableProductsInsertCommand
					+ "'Пуешко/бут', 'Месо, месни продукти', '114', '3.6', '20', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product177);
			String product178 = tableProductsInsertCommand
					+ "'Пуешко/гърди', 'Месо, месни продукти', '103', '1', '23', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product178);
			String product179 = tableProductsInsertCommand
					+ "'Пуйка', 'Месо, месни продукти', '160', '8', '20', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product179);
			String product180 = tableProductsInsertCommand
					+ "'Пушена наденица', 'Месо, месни продукти', '389', '32', '22', '2', 'гр.', 'общо');";
			dbStatement.executeUpdate(product180);
			String product181 = tableProductsInsertCommand
					+ "'Саздърма', 'Месо, месни продукти', '398', '34.3', '21.0', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product181);
			String product182 = tableProductsInsertCommand
					+ "'Салам камчия', 'Месо, месни продукти', '235', '16.4', '21.0', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product182);
			String product183 = tableProductsInsertCommand
					+ "'Свинска кайма', 'Месо, месни продукти', '263', '21', '17', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product183);
			String product184 = tableProductsInsertCommand
					+ "'Свинска мас', 'Месо, месни продукти', '902', '100', '0', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product184);
			String product185 = tableProductsInsertCommand
					+ "'Свински бут', 'Месо, месни продукти', '269', '23', '17', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product185);
			String product186 = tableProductsInsertCommand
					+ "'Свински дроб', 'Месо, месни продукти', '134', '4', '21', '2', 'гр.', 'общо');";
			dbStatement.executeUpdate(product186);
			String product187 = tableProductsInsertCommand
					+ "'Свински карета', 'Месо, месни продукти', '200', '13', '20', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product187);
			String product188 = tableProductsInsertCommand
					+ "'Свински крака', 'Месо, месни продукти', '264', '19', '22', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product188);
			String product189 = tableProductsInsertCommand
					+ "'Свински ребърца', 'Месо, месни продукти', '209', '14', '20', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product189);
			String product190 = tableProductsInsertCommand
					+ "'Свинско каре', 'Месо, месни продукти', '329', '30', '16', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product190);
			String product191 = tableProductsInsertCommand
					+ "'Свинско месо', 'Месо, месни продукти', '285', '24', '16', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product191);
			String product192 = tableProductsInsertCommand
					+ "'Свинско месо от бут', 'Месо, месни продукти', '219', '15.7', '18.8', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product192);
			String product193 = tableProductsInsertCommand
					+ "'Свинско филе', 'Месо, месни продукти', '134', '5.5', '20.5', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product193);
			String product194 = tableProductsInsertCommand
					+ "'Свинско филе - ребрена дъга', 'Месо, месни продукти', '209', '14.1', '19.9', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product194);
			String product195 = tableProductsInsertCommand
					+ "'Сланина', 'Месо, месни продукти', '900', '99', '0', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product195);
			String product196 = tableProductsInsertCommand
					+ "'Телешка кайма', 'Месо, месни продукти', '332', '30', '14', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product196);
			String product197 = tableProductsInsertCommand
					+ "'Телешка мазнина', 'Месо, месни продукти', '674', '71', '8', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product197);
			String product198 = tableProductsInsertCommand
					+ "'Телешки бут', 'Месо, месни продукти', '107', '2', '21', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product198);
			String product199 = tableProductsInsertCommand
					+ "'Телешки дроб', 'Месо, месни продукти', '135', '4', '20', '4', 'гр.', 'общо');";
			dbStatement.executeUpdate(product199);
			String product200 = tableProductsInsertCommand
					+ "'Телешки стек', 'Месо, месни продукти', '124', '4', '22', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product200);
			String product201 = tableProductsInsertCommand
					+ "'Телешко месо', 'Месо, месни продукти', '117', '3', '21', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product201);
			String product202 = tableProductsInsertCommand
					+ "'Телешко месо от бут', 'Месо, месни продукти', '114', '3.1', '21.0', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product202);
			String product203 = tableProductsInsertCommand
					+ "'Телешко месо от врат', 'Месо, месни продукти', '129', '5.5', '19.4', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product203);
			String product204 = tableProductsInsertCommand
					+ "'Телешко месо от плешка', 'Месо, месни продукти', '126', '5.2', '19.2', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product204);
			String product205 = tableProductsInsertCommand
					+ "'Телешко месо от подбедрица', 'Месо, месни продукти', '110', '3.5', '19.2', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product205);
			String product206 = tableProductsInsertCommand
					+ "'Телешко филе', 'Месо, месни продукти', '109', '3', '21', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product206);
			String product207 = tableProductsInsertCommand
					+ "'Хамбургски салам', 'Месо, месни продукти', '269', '22.0', '17.0', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product207);
			String product208 = tableProductsInsertCommand
					+ "'Черен дроб', 'Месо, месни продукти', '138', '5.7', '20.1', '1.1', 'гр.', 'общо');";
			dbStatement.executeUpdate(product208);
			String product209 = tableProductsInsertCommand
					+ "'Шкембе', 'Месо, месни продукти', '85', '4', '12', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product209);
			String product210 = tableProductsInsertCommand
					+ "'Шпеков салам', 'Месо, месни продукти', '458', '40.5', '22.0', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product210);
			String product211 = tableProductsInsertCommand
					+ "'Шунка', 'Месо, месни продукти', '93', '5', '18', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product211);
			String product212 = tableProductsInsertCommand
					+ "'Гауда', 'Мляко и млечни продукти', '356', '27', '25', '2', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product212);
			String product213 = tableProductsInsertCommand
					+ "'Заквасена сметана', 'Мляко и млечни продукти', '214', '21', '3', '4', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product213);
			String product214 = tableProductsInsertCommand
					+ "'Извара', 'Мляко и млечни продукти', '72', '1', '12', '3', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product214);
			String product215 = tableProductsInsertCommand
					+ "'Извара (кашкавал)', 'Мляко и млечни продукти', '145', '7', '18', '2', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product215);
			String product216 = tableProductsInsertCommand
					+ "'Извара (сирене)', 'Мляко и млечни продукти', '79', '0', '18', '2', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product216);
			String product217 = tableProductsInsertCommand
					+ "'Извара обезмаслена', 'Мляко и млечни продукти', '83', '0.6', '17.2', '1.8', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product217);
			String product218 = tableProductsInsertCommand
					+ "'Камамбер', 'Мляко и млечни продукти', '300', '24', '20', '0', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product218);
			String product219 = tableProductsInsertCommand
					+ "'Катък', 'Мляко и млечни продукти', '138', '10', '1', '1', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product219);
			String product220 = tableProductsInsertCommand
					+ "'Кашкавал', 'Мляко и млечни продукти', '330', '30', '20', '2', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product220);
			String product221 = tableProductsInsertCommand
					+ "'Кашкавал краве', 'Мляко и млечни продукти', '381', '29.6', '25.8', '1.6', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product221);
			String product222 = tableProductsInsertCommand
					+ "'Кашкавал овчи', 'Мляко и млечни продукти', '389', '30.9', '24.4', '2.0', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product222);
			String product223 = tableProductsInsertCommand
					+ "'Кисело мляко', 'Мляко и млечни продукти', '61', '3', '3', '5', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product223);
			String product224 = tableProductsInsertCommand
					+ "'Кисело мляко 0,1%', 'Мляко и млечни продукти', '33', '0.1', '3.3', '4.7', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product224);
			String product225 = tableProductsInsertCommand
					+ "'Кисело мляко 0.5%', 'Мляко и млечни продукти', '37', '0.5', '3', '4', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product225);
			String product226 = tableProductsInsertCommand
					+ "'Кисело мляко 2%', 'Мляко и млечни продукти', '42', '2', '3', '3', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product226);
			String product227 = tableProductsInsertCommand
					+ "'Кисело мляко 3,6%', 'Мляко и млечни продукти', '63', '3.6', '3.1', '4.5', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product227);
			String product228 = tableProductsInsertCommand
					+ "'Кисело мляко 3.6%', 'Мляко и млечни продукти', '60', '3.6', '3.2', '2.5', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product228);
			String product229 = tableProductsInsertCommand
					+ "'Кисело мляко 6.5%', 'Мляко и млечни продукти', '90', '6.5', '3.5', '2.5', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product229);
			String product230 = tableProductsInsertCommand
					+ "'Кисело мляко, цедено', 'Мляко и млечни продукти', '150', '11', '6', '5', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product230);
			String product231 = tableProductsInsertCommand
					+ "'Козе сирене', 'Мляко и млечни продукти', '452', '36', '31', '2', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product231);
			String product232 = tableProductsInsertCommand
					+ "'Кондензирано мляко', 'Мляко и млечни продукти', '244', '13', '13', '19', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product232);
			String product233 = tableProductsInsertCommand
					+ "'Краве сирене', 'Мляко и млечни продукти', '299', '24.7', '16.9', '1.4', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product233);
			String product234 = tableProductsInsertCommand
					+ "'Маскарпоне', 'Мляко и млечни продукти', '406', '41', '5', '2', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product234);
			String product235 = tableProductsInsertCommand
					+ "'Мляко', 'Мляко и млечни продукти', '61', '3', '3', '5', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product235);
			String product236 = tableProductsInsertCommand
					+ "'Моцарела', 'Мляко и млечни продукти', '300', '22', '22', '2', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product236);
			String product237 = tableProductsInsertCommand
					+ "'Овче сирене', 'Мляко и млечни продукти', '320', '27.0', '17.1', '1.1', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product237);
			String product238 = tableProductsInsertCommand
					+ "'Пармезан', 'Мляко и млечни продукти', '452', '33', '40', '0', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product238);
			String product239 = tableProductsInsertCommand
					+ "'Прясно мляко 0,1%', 'Мляко и млечни продукти', '35', '0.1', '3.5', '5.0', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product239);
			String product240 = tableProductsInsertCommand
					+ "'Прясно мляко 0.1%', 'Мляко и млечни продукти', '32', '0.5', '3', '5', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product240);
			String product241 = tableProductsInsertCommand
					+ "'Прясно мляко 1,5%', 'Мляко и млечни продукти', '46', '1.5', '3.3', '4.7', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product241);
			String product242 = tableProductsInsertCommand
					+ "'Прясно мляко 1.5%', 'Мляко и млечни продукти', '47', '1.5', '3', '5', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product242);
			String product243 = tableProductsInsertCommand
					+ "'Прясно мляко 3%', 'Мляко и млечни продукти', '60', '3', '3', '5', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product243);
			String product244 = tableProductsInsertCommand
					+ "'Прясно мляко 3,6%', 'Мляко и млечни продукти', '65', '3.6', '3.3', '4.7', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product244);
			String product245 = tableProductsInsertCommand
					+ "'Прясно мляко овче', 'Мляко и млечни продукти', '115', '7.7', '6.7', '4.5', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product245);
			String product246 = tableProductsInsertCommand
					+ "'Рикота', 'Мляко и млечни продукти', '174', '13', '11', '3', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product246);
			String product247 = tableProductsInsertCommand
					+ "'Синьо сирене', 'Мляко и млечни продукти', '353', '29', '21', '2', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product247);
			String product248 = tableProductsInsertCommand
					+ "'Сирене', 'Мляко и млечни продукти', '264', '21', '14', '4', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product248);
			String product249 = tableProductsInsertCommand
					+ "'Сирене бри', 'Мляко и млечни продукти', '334', '28', '21', '0', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product249);
			String product250 = tableProductsInsertCommand
					+ "'Сирене ементал', 'Мляко и млечни продукти', '376', '27', '28', '3', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product250);
			String product251 = tableProductsInsertCommand
					+ "'Сирене крема', 'Мляко и млечни продукти', '349', '35', '8', '3', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product251);
			String product252 = tableProductsInsertCommand
					+ "'Сирене мимолет', 'Мляко и млечни продукти', '347', '30', '19', '2', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product252);
			String product253 = tableProductsInsertCommand
					+ "'Сирене, бри', 'Мляко и млечни продукти', '319', '26', '19', '0', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product253);
			String product254 = tableProductsInsertCommand
					+ "'Сирене, козе', 'Мляко и млечни продукти', '364', '30', '22', '3', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product254);
			String product255 = tableProductsInsertCommand
					+ "'Сирене, краве', 'Мляко и млечни продукти', '300', '24', '17', '2', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product255);
			String product256 = tableProductsInsertCommand
					+ "'Сирене, крема', 'Мляко и млечни продукти', '297', '30', '6', '2', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product256);
			String product257 = tableProductsInsertCommand
					+ "'Сирене, рикота', 'Мляко и млечни продукти', '174', '13', '11', '3', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product257);
			String product258 = tableProductsInsertCommand
					+ "'Сирене, синьо', 'Мляко и млечни продукти', '353', '29', '21', '2', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product258);
			String product259 = tableProductsInsertCommand
					+ "'Сирене, фета', 'Мляко и млечни продукти', '250', '20', '15.5', '0', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product259);
			String product260 = tableProductsInsertCommand
					+ "'Сирене, чедар', 'Мляко и млечни продукти', '412', '35', '25', '0', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product260);
			String product261 = tableProductsInsertCommand
					+ "'Сирене, швейцарско', 'Мляко и млечни продукти', '350', '25', '25', '0', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product261);
			String product262 = tableProductsInsertCommand
					+ "'Сметана', 'Мляко и млечни продукти', '428', '45.0', '1.6', '3.0', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product262);
			String product263 = tableProductsInsertCommand
					+ "'Сметана 20%', 'Мляко и млечни продукти', '200', '20', '2', '2', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product263);
			String product264 = tableProductsInsertCommand
					+ "'Сметана 30 %', 'Мляко и млечни продукти', '300', '30', '2', '2', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product264);
			String product265 = tableProductsInsertCommand
					+ "'Суха сметана', 'Мляко и млечни продукти', '546', '35', '5', '55', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product265);
			String product266 = tableProductsInsertCommand
					+ "'Топено сирене', 'Мляко и млечни продукти', '229', '13', '14', '4', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product266);
			String product267 = tableProductsInsertCommand
					+ "'Фета', 'Мляко и млечни продукти', '349', '35', '8', '3', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product267);
			String product268 = tableProductsInsertCommand
					+ "'Цедено кисело мляко', 'Мляко и млечни продукти', '136', '10', '1', '11', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product268);
			String product269 = tableProductsInsertCommand
					+ "'Чедър', 'Мляко и млечни продукти', '403', '33', '25', '1', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product269);
			String product270 = tableProductsInsertCommand
					+ "'Швейцарско сирене', 'Мляко и млечни продукти', '376', '27', '28', '3', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product270);
			String product271 = tableProductsInsertCommand
					+ "'Мида', 'морски дарове', '74', '1', '13', '3', 'гр.', 'общо');";
			dbStatement.executeUpdate(product271);
			String product272 = tableProductsInsertCommand
					+ "'Октопод', 'морски дарове', '82', '1', '15', '2', 'гр.', 'общо');";
			dbStatement.executeUpdate(product272);
			String product273 = tableProductsInsertCommand
					+ "'Рак', 'морски дарове', '77', '1', '16', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product273);
			String product274 = tableProductsInsertCommand
					+ "'Рулца от раци', 'морски дарове', '99', '1', '15', '7', 'гр.', 'общо');";
			dbStatement.executeUpdate(product274);
			String product275 = tableProductsInsertCommand
					+ "'Скарида', 'морски дарове', '106', '2', '20', '1', 'гр.', 'общо');";
			dbStatement.executeUpdate(product275);
			String product276 = tableProductsInsertCommand + "'Бира', 'напитки', '41', '0', '0', '4', 'мл.', 'веган');";
			dbStatement.executeUpdate(product276);
			String product277 = tableProductsInsertCommand
					+ "'Бренди', 'напитки', '307', '0', '0', '7', 'мл.', 'веган');";
			dbStatement.executeUpdate(product277);
			String product278 = tableProductsInsertCommand
					+ "'Бяло вино', 'напитки', '68', '0', '0', '1', 'мл.', 'веган');";
			dbStatement.executeUpdate(product278);
			String product279 = tableProductsInsertCommand
					+ "'Вермут', 'напитки', '143', '0', '0', '7', 'мл.', 'веган');";
			dbStatement.executeUpdate(product279);
			String product280 = tableProductsInsertCommand
					+ "'Водка', 'напитки', '231', '0', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product280);
			String product281 = tableProductsInsertCommand
					+ "'Газирана вода', 'напитки', '0', '0', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product281);
			String product282 = tableProductsInsertCommand
					+ "'Гренадин', 'напитки', '268', '0', '0', '67', 'мл.', 'веган');";
			dbStatement.executeUpdate(product282);
			String product283 = tableProductsInsertCommand
					+ "'Джин', 'напитки', '231', '0', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product283);
			String product284 = tableProductsInsertCommand
					+ "'Инстантно кафе', 'напитки', '2', '0', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product284);
			String product285 = tableProductsInsertCommand
					+ "'Какао', 'напитки', '361', '4', '11', '79', 'мл.', 'веган');";
			dbStatement.executeUpdate(product285);
			String product286 = tableProductsInsertCommand + "'Кафе', 'напитки', '2', '0', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product286);
			String product287 = tableProductsInsertCommand
					+ "'Кока кола', 'напитки', '41', '0', '0', '10', 'мл.', 'веган');";
			dbStatement.executeUpdate(product287);
			String product288 = tableProductsInsertCommand
					+ "'Кокосов ром малибу', 'напитки', '243', '0', '0', '18', 'мл.', 'веган');";
			dbStatement.executeUpdate(product288);
			String product289 = tableProductsInsertCommand
					+ "'Коняк', 'напитки', '231', '0', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product289);
			String product290 = tableProductsInsertCommand
					+ "'Лимонада', 'напитки', '40', '0', '0', '10', 'мл.', 'веган');";
			dbStatement.executeUpdate(product290);
			String product291 = tableProductsInsertCommand
					+ "'Мирин', 'напитки', '263', '0', '0', '48', 'мл.', 'веган');";
			dbStatement.executeUpdate(product291);
			String product292 = tableProductsInsertCommand
					+ "'Нектар от кайсии', 'напитки', '56', '0', '0', '14', 'мл.', 'веган');";
			dbStatement.executeUpdate(product292);
			String product293 = tableProductsInsertCommand
					+ "'Оризово вино', 'напитки', '81', '0', '0', '2', 'мл.', 'веган');";
			dbStatement.executeUpdate(product293);
			String product294 = tableProductsInsertCommand
					+ "'Перно', 'напитки', '434', '0', '0', '39', 'мл.', 'веган');";
			dbStatement.executeUpdate(product294);
			String product295 = tableProductsInsertCommand
					+ "'Портокалов сок', 'напитки', '45', '0', '1', '10', 'мл.', 'веган');";
			dbStatement.executeUpdate(product295);
			String product296 = tableProductsInsertCommand
					+ "'Ракия', 'напитки', '231', '0', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product296);
			String product297 = tableProductsInsertCommand + "'Ром', 'напитки', '231', '0', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product297);
			String product298 = tableProductsInsertCommand
					+ "'Саке', 'напитки', '134', '0', '0', '5', 'мл.', 'веган');";
			dbStatement.executeUpdate(product298);
			String product299 = tableProductsInsertCommand
					+ "'Текила', 'напитки', '279', '0', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product299);
			String product300 = tableProductsInsertCommand
					+ "'Уиски', 'напитки', '250', '0', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product300);
			String product301 = tableProductsInsertCommand
					+ "'Червено вино', 'напитки', '72', '0', '0', '2', 'мл.', 'веган');";
			dbStatement.executeUpdate(product301);
			String product302 = tableProductsInsertCommand
					+ "'Черешово бренди', 'напитки', '302', '0', '0', '32', 'мл.', 'веган');";
			dbStatement.executeUpdate(product302);
			String product303 = tableProductsInsertCommand
					+ "'Шампанско', 'напитки', '133', '0', '0', '12', 'мл.', 'веган');";
			dbStatement.executeUpdate(product303);
			String product304 = tableProductsInsertCommand
					+ "'Боровинка', 'Плодове', '56', '0', '1', '14', 'гр.', 'веган');";
			dbStatement.executeUpdate(product304);
			String product305 = tableProductsInsertCommand
					+ "'Гродзе', 'Плодове', '60', '0.1', '0.4', '16', 'гр.', 'веган');";
			dbStatement.executeUpdate(product305);
			String product306 = tableProductsInsertCommand
					+ "'Грозде - бяло', 'Плодове', '38', '0.1', '0.7', '8.4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product306);
			String product307 = tableProductsInsertCommand
					+ "'Грозде - розово', 'Плодове', '48', '0.1', '0.8', '10.7', 'гр.', 'веган');";
			dbStatement.executeUpdate(product307);
			String product308 = tableProductsInsertCommand
					+ "'Грозде - червено', 'Плодове', '79', '0.2', '0.7', '18.2', 'гр.', 'веган');";
			dbStatement.executeUpdate(product308);
			String product309 = tableProductsInsertCommand
					+ "'Джанки', 'Плодове', '91', '0', '0', '22', 'гр.', 'веган');";
			dbStatement.executeUpdate(product309);
			String product310 = tableProductsInsertCommand
					+ "'Дюля', 'Плодове', '57', '0', '0', '15', 'гр.', 'веган');";
			dbStatement.executeUpdate(product310);
			String product311 = tableProductsInsertCommand
					+ "'Кайсия', 'Плодове', '48', '0', '1', '11', 'гр.', 'веган');";
			dbStatement.executeUpdate(product311);
			String product312 = tableProductsInsertCommand
					+ "'Кестен', 'Плодове', '213', '2', '2', '46', 'гр.', 'веган');";
			dbStatement.executeUpdate(product312);
			String product313 = tableProductsInsertCommand
					+ "'Кокос', 'Плодове', '354', '33', '3', '15', 'гр.', 'веган');";
			dbStatement.executeUpdate(product313);
			String product314 = tableProductsInsertCommand
					+ "'Компот от ананас', 'Плодове', '52', '0', '0', '13', 'мл.', 'веган');";
			dbStatement.executeUpdate(product314);
			String product315 = tableProductsInsertCommand
					+ "'Компот от праскова', 'Плодове', '54', '0', '0', '15', 'мл.', 'веган');";
			dbStatement.executeUpdate(product315);
			String product316 = tableProductsInsertCommand
					+ "'Круша', 'Плодове', '59', '0', '0', '15', 'гр.', 'веган');";
			dbStatement.executeUpdate(product316);
			String product317 = tableProductsInsertCommand
					+ "'Къпина', 'Плодове', '52', '0', '1', '13', 'гр.', 'веган');";
			dbStatement.executeUpdate(product317);
			String product318 = tableProductsInsertCommand
					+ "'Лайм', 'Плодове', '30', '0', '1', '11', 'гр.', 'веган');";
			dbStatement.executeUpdate(product318);
			String product319 = tableProductsInsertCommand
					+ "'Лимон', 'Плодове', '29', '0', '1', '9', 'гр.', 'веган');";
			dbStatement.executeUpdate(product319);
			String product320 = tableProductsInsertCommand
					+ "'Малина', 'Плодове', '49', '1', '1', '12', 'гр.', 'веган');";
			dbStatement.executeUpdate(product320);
			String product321 = tableProductsInsertCommand
					+ "'Портокал', 'Плодове', '47', '0', '1', '12', 'гр.', 'веган');";
			dbStatement.executeUpdate(product321);
			String product322 = tableProductsInsertCommand
					+ "'Праскова', 'Плодове', '43', '0', '1', '11', 'гр.', 'веган');";
			dbStatement.executeUpdate(product322);
			String product323 = tableProductsInsertCommand
					+ "'Синя слива', 'Плодове', '55', '1', '1', '13', 'гр.', 'веган');";
			dbStatement.executeUpdate(product323);
			String product324 = tableProductsInsertCommand
					+ "'Смокиня', 'Плодове', '74', '0', '1', '19', 'гр.', 'веган');";
			dbStatement.executeUpdate(product324);
			String product325 = tableProductsInsertCommand
					+ "'Сок от ананас', 'Плодове', '56', '0', '0', '14', 'мл.', 'веган');";
			dbStatement.executeUpdate(product325);
			String product326 = tableProductsInsertCommand
					+ "'Сок от боровинки', 'Плодове', '57', '0', '0', '14', 'мл.', 'веган');";
			dbStatement.executeUpdate(product326);
			String product327 = tableProductsInsertCommand
					+ "'Сок от грейпфрут', 'Плодове', '39', '0', '0', '9', 'мл.', 'веган');";
			dbStatement.executeUpdate(product327);
			String product328 = tableProductsInsertCommand
					+ "'Сок от мандарина', 'Плодове', '43', '0', '0', '10', 'мл.', 'веган');";
			dbStatement.executeUpdate(product328);
			String product329 = tableProductsInsertCommand
					+ "'Сок от ябълка', 'Плодове', '47', '0', '0', '12', 'мл.', 'веган');";
			dbStatement.executeUpdate(product329);
			String product330 = tableProductsInsertCommand
					+ "'Сок от ягоди', 'Плодове', '52', '0', '0', '13', 'мл.', 'веган');";
			dbStatement.executeUpdate(product330);
			String product331 = tableProductsInsertCommand
					+ "'Сушени череши', 'Плодове', '288', '4', '5', '66', 'гр.', 'веган');";
			dbStatement.executeUpdate(product331);
			String product332 = tableProductsInsertCommand
					+ "'Сушени ябълки', 'Плодове', '243', '0', '1', '66', 'гр.', 'веган');";
			dbStatement.executeUpdate(product332);
			String product333 = tableProductsInsertCommand
					+ "'Сушени ягоди', 'Плодове', '266', '3', '5', '62', 'гр.', 'веган');";
			dbStatement.executeUpdate(product333);
			String product334 = tableProductsInsertCommand
					+ "'Череша', 'Плодове', '72', '1', '1', '17', 'гр.', 'веган');";
			dbStatement.executeUpdate(product334);
			String product335 = tableProductsInsertCommand
					+ "'Авокадо', 'Плодове', '190', '20', '2', '2', 'гр.', 'веган');";
			dbStatement.executeUpdate(product335);
			String product336 = tableProductsInsertCommand
					+ "'Ананас', 'Плодове', '41', '0.2', '0.4', '11', 'гр.', 'веган');";
			dbStatement.executeUpdate(product336);
			String product337 = tableProductsInsertCommand
					+ "'Аспержи', 'зеленчуци', '25', '0.6', '3', '2', 'гр.', 'веган');";
			dbStatement.executeUpdate(product337);
			String product338 = tableProductsInsertCommand
					+ "'Бамя', 'зеленчуци', '31', '1', '3', '3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product338);
			String product339 = tableProductsInsertCommand
					+ "'Банан', 'Плодове', '95', '0.3', '1.2', '23', 'гр.', 'веган');";
			dbStatement.executeUpdate(product339);
			String product340 = tableProductsInsertCommand
					+ "'Грах', 'зеленчуци', '69', '1', '6', '10', 'гр.', 'веган');";
			dbStatement.executeUpdate(product340);
			String product341 = tableProductsInsertCommand
					+ "'Грейпфрут', 'Плодове', '20', '0', '0.5', '5', 'гр.', 'веган');";
			dbStatement.executeUpdate(product341);
			String product342 = tableProductsInsertCommand
					+ "'Диня', 'Плодове', '31', '0.3', '0.5', '7', 'гр.', 'веган');";
			dbStatement.executeUpdate(product342);
			String product343 = tableProductsInsertCommand
					+ "'Домат', 'зеленчуци', '17', '0', '0.7', '3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product343);
			String product344 = tableProductsInsertCommand
					+ "'Замразени зеленчуци - микс', 'зеленчуци', '42', '0.5', '3.3', '6.6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product344);
			String product345 = tableProductsInsertCommand
					+ "'Зеле', 'зеленчуци', '26', '0.4', '1.7', '4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product345);
			String product346 = tableProductsInsertCommand
					+ "'Зелен боб', 'зеленчуци', '31', '0', '2', '7', 'гр.', 'веган');";
			dbStatement.executeUpdate(product346);
			String product347 = tableProductsInsertCommand
					+ "'Кайсии', 'Плодове', '31', '0.3', '0.1', '9', 'гр.', 'веган');";
			dbStatement.executeUpdate(product347);
			String product348 = tableProductsInsertCommand
					+ "'Каперси', 'зеленчуци', '28', '0.7', '2', '3.4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product348);
			String product349 = tableProductsInsertCommand
					+ "'Карфиол', 'зеленчуци', '34', '1', '3.6', '3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product349);
			String product350 = tableProductsInsertCommand
					+ "'Касис', 'Плодове', '28', '0', '1', '6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product350);
			String product351 = tableProductsInsertCommand
					+ "'Киви', 'Плодове', '49', '0', '1', '11', 'гр.', 'веган');";
			dbStatement.executeUpdate(product351);
			String product352 = tableProductsInsertCommand
					+ "'Краставица', 'зеленчуци', '10', '0', '0.7', '1,5', 'гр.', 'веган');";
			dbStatement.executeUpdate(product352);
			String product353 = tableProductsInsertCommand
					+ "'Круши', 'Плодове', '40', '0', '0.3', '10', 'гр.', 'веган');";
			dbStatement.executeUpdate(product353);
			String product354 = tableProductsInsertCommand
					+ "'Кумкуат', 'Плодове', '60', '0', '0', '15', 'гр.', 'веган');";
			dbStatement.executeUpdate(product354);
			String product355 = tableProductsInsertCommand
					+ "'Къпини', 'Плодове', '56', '0', '0.7', '14', 'гр.', 'веган');";
			dbStatement.executeUpdate(product355);
			String product356 = tableProductsInsertCommand
					+ "'Лимони', 'Плодове', '19', '0', '1', '3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product356);
			String product357 = tableProductsInsertCommand
					+ "'Лук пресен', 'зеленчуци', '23', '0.5', '2', '3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product357);
			String product358 = tableProductsInsertCommand
					+ "'Лук стар', 'зеленчуци', '36', '0.2', '1.2', '8', 'гр.', 'веган');";
			dbStatement.executeUpdate(product358);
			String product359 = tableProductsInsertCommand
					+ "'Малини', 'зеленчуци', '25', '0', '1,4', '5', 'гр.', 'веган');";
			dbStatement.executeUpdate(product359);
			String product360 = tableProductsInsertCommand
					+ "'Манго', 'Плодове', '57', '0', '1', '14', 'гр.', 'веган');";
			dbStatement.executeUpdate(product360);
			String product361 = tableProductsInsertCommand
					+ "'Мандарини', 'Плодове', '35', '0', '1', '8', 'гр.', 'веган');";
			dbStatement.executeUpdate(product361);
			String product362 = tableProductsInsertCommand
					+ "'Маруля', 'зеленчуци', '14', '0.5', '0.8', '1.7', 'гр.', 'веган');";
			dbStatement.executeUpdate(product362);
			String product363 = tableProductsInsertCommand
					+ "'Моркови', 'зеленчуци', '41', '0.4', '0.6', '8', 'гр.', 'веган');";
			dbStatement.executeUpdate(product363);
			String product364 = tableProductsInsertCommand
					+ "'Нахут', 'Хлебни изделия и зърнени храни', '89', '0.4', '7.8', '14', 'гр.', 'веган');";
			dbStatement.executeUpdate(product364);
			String product365 = tableProductsInsertCommand
					+ "'Нектарини', 'Плодове', '40', '0', '1', '9', 'гр.', 'веган');";
			dbStatement.executeUpdate(product365);
			String product366 = tableProductsInsertCommand
					+ "'Патладжан', 'зеленчуци', '24', '3', '1', '6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product366);
			String product367 = tableProductsInsertCommand
					+ "'Портокали', 'Плодове', '37', '0', '1', '8', 'гр.', 'веган');";
			dbStatement.executeUpdate(product367);
			String product368 = tableProductsInsertCommand
					+ "'Праз', 'зеленчуци', '22', '0.5', '1.6', '2.9', 'гр.', 'веган');";
			dbStatement.executeUpdate(product368);
			String product369 = tableProductsInsertCommand
					+ "'Праскови', 'Плодове', '33', '0', '1', '8', 'гр.', 'веган');";
			dbStatement.executeUpdate(product369);
			String product370 = tableProductsInsertCommand
					+ "'Пресни картофи', 'зеленчуци', '75', '0', '1.5', '17', 'гр.', 'веган');";
			dbStatement.executeUpdate(product370);
			String product371 = tableProductsInsertCommand
					+ "'Пъпеш', 'Плодове', '28', '0', '1', '6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product371);
			String product372 = tableProductsInsertCommand
					+ "'Репички', 'зеленчуци', '16', '0', '1', '3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product372);
			String product373 = tableProductsInsertCommand
					+ "'Рукола', 'зеленчуци', '26', '0', '3', '5', 'гр.', 'веган');";
			dbStatement.executeUpdate(product373);
			String product374 = tableProductsInsertCommand
					+ "'Сини сливи', 'Плодове', '35', '0', '0.5', '5', 'гр.', 'веган');";
			dbStatement.executeUpdate(product374);
			String product375 = tableProductsInsertCommand
					+ "'Сладки картофи', 'зеленчуци', '84', '0', '1', '20', 'гр.', 'веган');";
			dbStatement.executeUpdate(product375);
			String product376 = tableProductsInsertCommand
					+ "'Спанак', 'зеленчуци', '7', '0', '3', '4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product376);
			String product377 = tableProductsInsertCommand
					+ "'Стари картофи', 'зеленчуци', '136', '0', '4', '32', 'гр.', 'веган');";
			dbStatement.executeUpdate(product377);
			String product378 = tableProductsInsertCommand
					+ "'Стафиди', 'Плодове', '272', '0.4', '2', '70', 'гр.', 'веган');";
			dbStatement.executeUpdate(product378);
			String product379 = tableProductsInsertCommand
					+ "'Сушени смокини', 'Плодове', '227', '0', '0.7', '52', 'гр.', 'веган');";
			dbStatement.executeUpdate(product379);
			String product380 = tableProductsInsertCommand
					+ "'Тиква', 'Плодове', '26', '0', '1', '6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product380);
			String product381 = tableProductsInsertCommand
					+ "'Тиквичка', 'зеленчуци', '20', '0', '2', '4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product381);
			String product382 = tableProductsInsertCommand
					+ "'Фурми', 'Плодове', '227', '0.2', '2.8', '57', 'гр.', 'веган');";
			dbStatement.executeUpdate(product382);
			String product383 = tableProductsInsertCommand
					+ "'Царевица', 'Хлебни изделия и зърнени храни', '88', '1', '3', '21', 'гр.', 'веган');";
			dbStatement.executeUpdate(product383);
			String product384 = tableProductsInsertCommand
					+ "'Череши', 'Плодове', '48', '0.4', '1', '12', 'гр.', 'веган');";
			dbStatement.executeUpdate(product384);
			String product385 = tableProductsInsertCommand
					+ "'Чушки', 'зеленчуци', '20', '0', '1', '5', 'гр.', 'веган');";
			dbStatement.executeUpdate(product385);
			String product386 = tableProductsInsertCommand
					+ "'Ябълки', 'Плодове', '42', '0.1', ' 0.4', '12', 'гр.', 'веган');";
			dbStatement.executeUpdate(product386);
			String product387 = tableProductsInsertCommand
					+ "'Ягоди', 'Плодове', '27', '0', '1', '6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product387);
			String product388 = tableProductsInsertCommand
					+ "'Бадеми печени', 'Ядки', '632', '51.0', '21.0', '20.0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product388);
			String product389 = tableProductsInsertCommand
					+ "'Бадеми сурови', 'Ядки', '647', '57.0', '15.0', '16.4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product389);
			String product390 = tableProductsInsertCommand
					+ "'Вишни', 'Плодове', '62', '0.4', '1.2', '13.1', 'гр.', 'веган');";
			dbStatement.executeUpdate(product390);
			String product391 = tableProductsInsertCommand
					+ "'Круши - азиатски', 'Плодове', '47', '0.2', '0.5', '10.7', 'гр.', 'веган');";
			dbStatement.executeUpdate(product391);
			String product392 = tableProductsInsertCommand
					+ "'Круши - диви', 'Плодове', '46', '0.5', '0.7', '9.6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product392);
			String product393 = tableProductsInsertCommand
					+ "'Ленено семе', 'Хлебни изделия и зърнени храни', '380', '31.0', '24.0', '0.0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product393);
			String product394 = tableProductsInsertCommand
					+ "'Нар', 'Плодове', '77', '0.3', '1.0', '17.2', 'гр.', 'веган');";
			dbStatement.executeUpdate(product394);
			String product395 = tableProductsInsertCommand
					+ "'Помело', 'Плодове', '48', '0.5', '0.7', '10.0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product395);
			String product396 = tableProductsInsertCommand
					+ "'Сливи сини', 'Плодове', '81', '0.2', '0.8', '18.7', 'гр.', 'веган');";
			dbStatement.executeUpdate(product396);
			String product397 = tableProductsInsertCommand
					+ "'Слънчоглед', 'Ядки', '610', '55.8', '21.0', '4.1', 'гр.', 'веган');";
			dbStatement.executeUpdate(product397);
			String product398 = tableProductsInsertCommand
					+ "'Смокини', 'Плодове', '84', '0.3', '0.8', '19.2', 'гр.', 'веган');";
			dbStatement.executeUpdate(product398);
			String product399 = tableProductsInsertCommand
					+ "'Сушени кайсии', 'Плодове', '275', '0.5', '3.4', '62.6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product399);
			String product400 = tableProductsInsertCommand
					+ "'Сушени сливи', 'Плодове', '274', '0.4', '2.2', '63.9', 'гр.', 'веган');";
			dbStatement.executeUpdate(product400);
			String product401 = tableProductsInsertCommand
					+ "'Тиквени семки', 'Ядки', '593', '45.0', '32.4', '12.5', 'гр.', 'веган');";
			dbStatement.executeUpdate(product401);
			String product402 = tableProductsInsertCommand
					+ "'Бакпулвер', 'подправки', '0', '0', '0', '0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product402);
			String product403 = tableProductsInsertCommand
					+ "'Балсамов оцет', 'подправки', '88', '0', '0', '17', 'мл', 'веган');";
			dbStatement.executeUpdate(product403);
			String product404 = tableProductsInsertCommand
					+ "'Бахар', 'подправки', '263', '9', '6', '72', 'гр.', 'веган');";
			dbStatement.executeUpdate(product404);
			String product405 = tableProductsInsertCommand
					+ "'Босилек', 'подправки', '27', '1', '3', '4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product405);
			String product406 = tableProductsInsertCommand
					+ "'Бульон', 'подправки', '13', '0', '2', '1', 'гр.', 'веган');";
			dbStatement.executeUpdate(product406);
			String product407 = tableProductsInsertCommand
					+ "'Бял пипер', 'подправки', '296', '2', '10', '69', 'гр.', 'веган');";
			dbStatement.executeUpdate(product407);
			String product408 = tableProductsInsertCommand
					+ "'Ванилия', 'подправки', '288', '0', '0', '13', 'гр.', 'веган');";
			dbStatement.executeUpdate(product408);
			String product409 = tableProductsInsertCommand
					+ "'Горчица', 'подправки', '66', '3', '4', '8', 'гр.', 'веган');";
			dbStatement.executeUpdate(product409);
			String product410 = tableProductsInsertCommand
					+ "'Градински чай', 'подправки', '315', '13', '11', '61', 'гр.', 'веган');";
			dbStatement.executeUpdate(product410);
			String product411 = tableProductsInsertCommand
					+ "'Дафинов лист', 'подправки', '313', '8', '8', '75', 'гр.', 'веган');";
			dbStatement.executeUpdate(product411);
			String product412 = tableProductsInsertCommand
					+ "'Джинджифил', 'подправки', '69', '1', '2', '15', 'гр.', 'веган');";
			dbStatement.executeUpdate(product412);
			String product413 = tableProductsInsertCommand
					+ "'Джоджен', 'подправки', '44', '1', '3', '8', 'гр.', 'веган');";
			dbStatement.executeUpdate(product413);
			String product414 = tableProductsInsertCommand
					+ "'Див лук', 'подправки', '30', '1', '3', '4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product414);
			String product415 = tableProductsInsertCommand
					+ "'Дивесил', 'подправки', '93', '2', '4', '20', 'гр.', 'веган');";
			dbStatement.executeUpdate(product415);
			String product416 = tableProductsInsertCommand
					+ "'Естрагон', 'подправки', '295', '7', '23', '50', 'гр.', 'веган');";
			dbStatement.executeUpdate(product416);
			String product417 = tableProductsInsertCommand
					+ "'Зелени подправки', 'подправки', '51', '1', '4', '11', 'гр.', 'веган');";
			dbStatement.executeUpdate(product417);
			String product418 = tableProductsInsertCommand
					+ "'Зеленчуков микс', 'подправки', '68', '1', '3', '14', 'гр.', 'веган');";
			dbStatement.executeUpdate(product418);
			String product419 = tableProductsInsertCommand
					+ "'Индийско орехче', 'подправки', '525', '36', '6', '49', 'гр.', 'веган');";
			dbStatement.executeUpdate(product419);
			String product420 = tableProductsInsertCommand
					+ "'Кайенски пипер', 'подправки', '318', '17', '12', '57', 'гр.', 'веган');";
			dbStatement.executeUpdate(product420);
			String product421 = tableProductsInsertCommand
					+ "'Канела', 'подправки', '261', '3', '4', '80', 'гр.', 'веган');";
			dbStatement.executeUpdate(product421);
			String product422 = tableProductsInsertCommand
					+ "'Карамфил', 'подправки', '323', '20', '6', '61', 'гр.', 'веган');";
			dbStatement.executeUpdate(product422);
			String product423 = tableProductsInsertCommand
					+ "'Кардамон', 'подправки', '311', '7', '11', '68', 'гр.', 'веган');";
			dbStatement.executeUpdate(product423);
			String product424 = tableProductsInsertCommand
					+ "'Кетчуп', 'подправки', '102', '0', '1', '26', 'гр.', 'веган');";
			dbStatement.executeUpdate(product424);
			String product425 = tableProductsInsertCommand
					+ "'Ким', 'подправки', '375', '22', '18', '44', 'гр.', 'веган');";
			dbStatement.executeUpdate(product425);
			String product426 = tableProductsInsertCommand
					+ "'Кимион', 'подправки', '333', '15', '20', '50', 'гр.', 'веган');";
			dbStatement.executeUpdate(product426);
			String product427 = tableProductsInsertCommand
					+ "'Кленов сироп', 'подправки', '262', '0', '0', '67', 'мл.', 'веган');";
			dbStatement.executeUpdate(product427);
			String product428 = tableProductsInsertCommand
					+ "'Кокосова сметана', 'подправки', '330', '35', '4', '7', 'мл.', 'веган');";
			dbStatement.executeUpdate(product428);
			String product429 = tableProductsInsertCommand
					+ "'Кокосово мляко', 'подправки', '230', '24', '2', '6', 'мл.', 'веган');";
			dbStatement.executeUpdate(product429);
			String product430 = tableProductsInsertCommand
					+ "'Копър', 'подправки', '43', '1', '3', '7', 'гр.', 'веган');";
			dbStatement.executeUpdate(product430);
			String product431 = tableProductsInsertCommand
					+ "'Корен от магданоз', 'подправки', '63', '0', '3', '14', 'гр.', 'веган');";
			dbStatement.executeUpdate(product431);
			String product432 = tableProductsInsertCommand
					+ "'Корен от целина', 'подправки', '65', '0', '3', '15', 'гр.', 'веган');";
			dbStatement.executeUpdate(product432);
			String product433 = tableProductsInsertCommand
					+ "'Кориандър', 'подправки', '298', '18', '12', '55', 'гр.', 'веган');";
			dbStatement.executeUpdate(product433);
			String product434 = tableProductsInsertCommand
					+ "'Куркума', 'подправки', '354', '10', '8', '65', 'гр.', 'веган');";
			dbStatement.executeUpdate(product434);
			String product435 = tableProductsInsertCommand
					+ "'Къри', 'подправки', '325', '14', '13', '58', 'гр.', 'веган');";
			dbStatement.executeUpdate(product435);
			String product436 = tableProductsInsertCommand
					+ "'Лимонена трева', 'подправки', '99', '0', '2', '25', 'гр.', 'веган');";
			dbStatement.executeUpdate(product436);
			String product437 = tableProductsInsertCommand
					+ "'Лимонов сок', 'подправки', '25', '0', '0', '9', 'гр.', 'веган');";
			dbStatement.executeUpdate(product437);
			String product438 = tableProductsInsertCommand
					+ "'Лимонова кора', 'подправки', '47', '0', '2', '16', 'гр.', 'веган');";
			dbStatement.executeUpdate(product438);
			String product439 = tableProductsInsertCommand
					+ "'Лимонтузу', 'подправки', '258', '0', '0', '62', 'гр.', 'веган');";
			dbStatement.executeUpdate(product439);
			String product440 = tableProductsInsertCommand
					+ "'Лют пипер', 'подправки', '314', '17', '12', '55', 'гр.', 'веган');";
			dbStatement.executeUpdate(product440);
			String product441 = tableProductsInsertCommand
					+ "'Магданоз', 'подправки', '36', '1', '3', '6', 'гр.', 'веган');";
			dbStatement.executeUpdate(product441);
			String product442 = tableProductsInsertCommand
					+ "'Майорам', 'подправки', '271', '7', '13', '61', 'гр.', 'веган');";
			dbStatement.executeUpdate(product442);
			String product443 = tableProductsInsertCommand
					+ "'Маково семе', 'подправки', '533', '45', '18', '24', 'гр.', 'веган');";
			dbStatement.executeUpdate(product443);
			String product444 = tableProductsInsertCommand
					+ "'Мащерка', 'подправки', '101', '2', '6', '24', 'гр.', 'веган');";
			dbStatement.executeUpdate(product444);
			String product445 = tableProductsInsertCommand
					+ "'Мая', 'подправки', '295', '5', '38', '38', 'гр.', 'веган');";
			dbStatement.executeUpdate(product445);
			String product446 = tableProductsInsertCommand
					+ "'Мента', 'подправки', '70', '1', '4', '15', 'гр.', 'веган');";
			dbStatement.executeUpdate(product446);
			String product447 = tableProductsInsertCommand
					+ "'Мисо', 'подправки', '206', '6', '12', '28', 'гр.', 'веган');";
			dbStatement.executeUpdate(product447);
			String product448 = tableProductsInsertCommand
					+ "'Оризов оцет', 'подправки', '42', '0', '0', '1', 'мл.', 'веган');";
			dbStatement.executeUpdate(product448);
			String product449 = tableProductsInsertCommand
					+ "'Оцет', 'подправки', '19', '0', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product449);
			String product450 = tableProductsInsertCommand
					+ "'Пащърнак', 'подправки', '75', '0', '1', '18', 'гр.', 'веган');";
			dbStatement.executeUpdate(product450);
			String product451 = tableProductsInsertCommand
					+ "'Песто', 'подправки', '182', '16', '6', '5', 'гр.', 'веган');";
			dbStatement.executeUpdate(product451);
			String product452 = tableProductsInsertCommand
					+ "'Порокалова кора', 'подправки', '97', '0', '2', '25', 'гр.', 'веган');";
			dbStatement.executeUpdate(product452);
			String product453 = tableProductsInsertCommand
					+ "'Риган', 'подправки', '306', '10', '11', '64', 'гр.', 'веган');";
			dbStatement.executeUpdate(product453);
			String product454 = tableProductsInsertCommand
					+ "'Розмарин', 'подправки', '131', '6', '3', '21', 'гр.', 'веган');";
			dbStatement.executeUpdate(product454);
			String product455 = tableProductsInsertCommand
					+ "'Семена от копър', 'подправки', '305', '15', '16', '55', 'гр.', 'веган');";
			dbStatement.executeUpdate(product455);
			String product456 = tableProductsInsertCommand
					+ "'Синап', 'подправки', '469', '29', '25', '35', 'гр.', 'веган');";
			dbStatement.executeUpdate(product456);
			String product457 = tableProductsInsertCommand
					+ "'Сода', 'подправки', '0', '0', '0', '0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product457);
			String product458 = tableProductsInsertCommand
					+ "'Соев протеин', 'подправки', '338', '3', '81', '7', 'гр.', 'веган');";
			dbStatement.executeUpdate(product458);
			String product459 = tableProductsInsertCommand
					+ "'Соев сос', 'подправки', '53', '0', '5', '9', 'мл.', 'веган');";
			dbStatement.executeUpdate(product459);
			String product460 = tableProductsInsertCommand
					+ "'Сок от кисело зеле', 'подправки', '4', '0', '0', '1', 'мл.', 'веган');";
			dbStatement.executeUpdate(product460);
			String product461 = tableProductsInsertCommand
					+ "'Сок от лайм', 'подправки', '27', '0', '0', '9', 'мл.', 'веган');";
			dbStatement.executeUpdate(product461);
			String product462 = tableProductsInsertCommand + "'Сол', 'подправки', '0', '0', '0', '0', 'мл.', 'веган');";
			dbStatement.executeUpdate(product462);
			String product463 = tableProductsInsertCommand
					+ "'Сос уорчестър', 'подправки', '78', '0', '0', '19', 'мл.', 'веган');";
			dbStatement.executeUpdate(product463);
			String product464 = tableProductsInsertCommand
					+ "'Фенел', 'подправки', '31', '0', '1', '7', 'гр.', 'веган');";
			dbStatement.executeUpdate(product464);
			String product465 = tableProductsInsertCommand
					+ "'Хрян', 'подправки', '48', '1', '1', '11', 'гр.', 'веган');";
			dbStatement.executeUpdate(product465);
			String product466 = tableProductsInsertCommand
					+ "'Цикория', 'подправки', '17', '0', '1', '3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product466);
			String product467 = tableProductsInsertCommand
					+ "'Червен пипер', 'подправки', '289', '13', '15', '56', 'гр.', 'веган');";
			dbStatement.executeUpdate(product467);
			String product468 = tableProductsInsertCommand
					+ "'Черен пипер', 'подправки', '255', '3', '11', '65', 'гр.', 'веган');";
			dbStatement.executeUpdate(product468);
			String product469 = tableProductsInsertCommand
					+ "'Чесън', 'подправки', '149', '0', '6', '33', 'гр.', 'веган');";
			dbStatement.executeUpdate(product469);
			String product470 = tableProductsInsertCommand
					+ "'Чесън на прах', 'подправки', '332', '1', '17', '73', 'гр.', 'веган');";
			dbStatement.executeUpdate(product470);
			String product471 = tableProductsInsertCommand
					+ "'Чили', 'подправки', '314', '17', '12', '55', 'гр.', 'веган');";
			dbStatement.executeUpdate(product471);
			String product472 = tableProductsInsertCommand
					+ "'Чили сос', 'подправки', '104', '0', '2', '20', 'мл.', 'веган');";
			dbStatement.executeUpdate(product472);
			String product473 = tableProductsInsertCommand
					+ "'Чубрица', 'подправки', '272', '6', '7', '69', 'гр.', 'веган');";
			dbStatement.executeUpdate(product473);
			String product474 = tableProductsInsertCommand
					+ "'Шафран', 'подправки', '310', '6', '11', '65', 'гр.', 'веган');";
			dbStatement.executeUpdate(product474);
			String product475 = tableProductsInsertCommand
					+ "'Ябълков оцет', 'подправки', '14', '0', '0', '6', 'мл.', 'веган');";
			dbStatement.executeUpdate(product475);
			String product476 = tableProductsInsertCommand
					+ "'Мед', 'пчелен продукт', '322', '0.0', '0.4', '78.3', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product476);
			String product477 = tableProductsInsertCommand
					+ "'Акула', 'Риба и рибни продукти', '130', '5', '21', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product477);
			String product478 = tableProductsInsertCommand
					+ "'Аншоа', 'Риба и рибни продукти', '131', '5', '20', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product478);
			String product479 = tableProductsInsertCommand
					+ "'Аншоа консерва', 'Риба и рибни продукти', '280', '20', '25', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product479);
			String product480 = tableProductsInsertCommand
					+ "'Бял амур', 'Риба и рибни продукти', '130', '6.4', '17.6', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product480);
			String product481 = tableProductsInsertCommand
					+ "'Бяла риба', 'Риба и рибни продукти', '77', '0.6', '17.6', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product481);
			String product482 = tableProductsInsertCommand
					+ "'Даши', 'Риба и рибни продукти', '0', '0', '0', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product482);
			String product483 = tableProductsInsertCommand
					+ "'Зарган', 'Риба и рибни продукти', '91', '2', '18', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product483);
			String product484 = tableProductsInsertCommand
					+ "'Калкан', 'Риба и рибни продукти', '70', '0.6', '15.8', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product484);
			String product485 = tableProductsInsertCommand
					+ "'Калмар', 'Риба и рибни продукти', '92', '1', '16', '3', 'гр.', 'общо');";
			dbStatement.executeUpdate(product485);
			String product486 = tableProductsInsertCommand
					+ "'Карагьоз', 'Риба и рибни продукти', '249', '20.4', '15.5', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product486);
			String product487 = tableProductsInsertCommand
					+ "'Кефал', 'Риба и рибни продукти', '102', '2.5', '19.4', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product487);
			String product488 = tableProductsInsertCommand
					+ "'Копърка', 'Риба и рибни продукти', '66', '0.8', '14.5', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product488);
			String product489 = tableProductsInsertCommand
					+ "'Лаврак', 'Риба и рибни продукти', '128', '3.3', '23.9', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product489);
			String product490 = tableProductsInsertCommand
					+ "'Лефер', 'Риба и рибни продукти', '103', '2.5', '19.8', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product490);
			String product491 = tableProductsInsertCommand
					+ "'Маслена риба', 'Риба и рибни продукти', '146', '8', '17', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product491);
			String product492 = tableProductsInsertCommand
					+ "'Мерлуза', 'Риба и рибни продукти', '72', '0.5', '16.5', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product492);
			String product493 = tableProductsInsertCommand
					+ "'Омар', 'Риба и рибни продукти', '85', '0.9', '18.8', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product493);
			String product494 = tableProductsInsertCommand
					+ "'Паламуд', 'Риба и рибни продукти', '129', '5.0', '20.5', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product494);
			String product495 = tableProductsInsertCommand
					+ "'Пангасиус', 'Риба и рибни продукти', '115', '4', '18', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product495);
			String product496 = tableProductsInsertCommand
					+ "'Пушена скумрия', 'Риба и рибни продукти', '262', '18', '24', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product496);
			String product497 = tableProductsInsertCommand
					+ "'Пушена сьомга', 'Риба и рибни продукти', '117', '4', '18', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product497);
			String product498 = tableProductsInsertCommand
					+ "'Пъстърва', 'Риба и рибни продукти', '117', '5', '16', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product498);
			String product499 = tableProductsInsertCommand
					+ "'Риба тон', 'Риба и рибни продукти', '140', '4.9', '23.3', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product499);
			String product500 = tableProductsInsertCommand
					+ "'Риба тон (консерва с олио)', 'Риба и рибни продукти', '198', '8', '29', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product500);
			String product501 = tableProductsInsertCommand
					+ "'Риба тон във вода', 'Риба и рибни продукти', '91', '0.5', '22', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product501);
			String product502 = tableProductsInsertCommand
					+ "'Рибен сос', 'Риба и рибни продукти', '57', '0', '0', '14', 'гр.', 'общо');";
			dbStatement.executeUpdate(product502);
			String product503 = tableProductsInsertCommand
					+ "'Сардина', 'Риба и рибни продукти', '126', '5.2', '19.4', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product503);
			String product504 = tableProductsInsertCommand
					+ "'Сардини в олио', 'Риба и рибни продукти', '217', '14', '24', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product504);
			String product505 = tableProductsInsertCommand
					+ "'Сафрид', 'Риба и рибни продукти', '95', '2.1', '18.6', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product505);
			String product506 = tableProductsInsertCommand
					+ "'Скариди', 'Риба и рибни продукти', '107', '1.2', '21', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product506);
			String product507 = tableProductsInsertCommand
					+ "'Скат', 'Риба и рибни продукти', '97', '5', '12', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product507);
			String product508 = tableProductsInsertCommand
					+ "'Скумрия', 'Риба и рибни продукти', '223', '16', '19', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product508);
			String product509 = tableProductsInsertCommand
					+ "'Сом', 'Риба и рибни продукти', '157', '11.3', '13.3', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product509);
			String product510 = tableProductsInsertCommand
					+ "'Сьомга', 'Риба и рибни продукти', '182', '19', '12', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product510);
			String product511 = tableProductsInsertCommand
					+ "'Сьомга - атлантическа', 'Риба и рибни продукти', '138', '6.3', '19.9', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product511);
			String product512 = tableProductsInsertCommand
					+ "'Треска', 'Риба и рибни продукти', '76', '0.7', '17', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product512);
			String product513 = tableProductsInsertCommand
					+ "'Трицона', 'Риба и рибни продукти', '126', '5.5', '18.6', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product513);
			String product514 = tableProductsInsertCommand
					+ "'Филе от акула', 'Риба и рибни продукти', '118', '4.0', '20.0', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product514);
			String product515 = tableProductsInsertCommand
					+ "'Хайвер', 'Риба и рибни продукти', '74', '2', '10', '4', 'гр.', 'общо');";
			dbStatement.executeUpdate(product515);
			String product516 = tableProductsInsertCommand
					+ "'Хайвер-сьомга', 'Риба и рибни продукти', '266', '15.5', '26.1', '4.6', 'гр.', 'общо');";
			dbStatement.executeUpdate(product516);
			String product517 = tableProductsInsertCommand
					+ "'Хайвер-шаран', 'Риба и рибни продукти', '173', '6.8', '27.2', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product517);
			String product518 = tableProductsInsertCommand
					+ "'Хек', 'Риба и рибни продукти', '93', '2.3', '17.7', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product518);
			String product519 = tableProductsInsertCommand
					+ "'Херинга', 'Риба и рибни продукти', '129', '4.9', '20.7', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product519);
			String product520 = tableProductsInsertCommand
					+ "'Цаца', 'Риба и рибни продукти', '121', '5.6', '17.3', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product520);
			String product521 = tableProductsInsertCommand
					+ "'Черни миди', 'Риба и рибни продукти', '48', '1', '11', '0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product521);
			String product522 = tableProductsInsertCommand
					+ "'Чига', 'Риба и рибни продукти', '128', '6.0', '18.0', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product522);
			String product523 = tableProductsInsertCommand
					+ "'Шаран', 'Риба и рибни продукти', '123', '5.6', '17.8', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product523);
			String product524 = tableProductsInsertCommand
					+ "'Щука', 'Риба и рибни продукти', '82', '0.8', '18.4', '0.0', 'гр.', 'общо');";
			dbStatement.executeUpdate(product524);
			String product525 = tableProductsInsertCommand
					+ "'Бегета', 'Хлебни изделия и зърнени храни', '275', '2', '10', '53', 'гр.', 'веган');";
			dbStatement.executeUpdate(product525);
			String product526 = tableProductsInsertCommand
					+ "'Бисквити', 'Захарни изделия', '364', '16', '6', '48', 'гр.', 'веган');";
			dbStatement.executeUpdate(product526);
			String product527 = tableProductsInsertCommand
					+ "'Бишкоти', 'Захарни изделия', '365', '9', '11', '60', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product527);
			String product528 = tableProductsInsertCommand
					+ "'Блат за торта', 'Хлебни изделия и зърнени храни', '289', '3', '5', '61', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product528);
			String product529 = tableProductsInsertCommand
					+ "'Брашно', 'Хлебни изделия и зърнени храни', '364', '1', '10', '76', 'гр.', 'веган');";
			dbStatement.executeUpdate(product529);
			String product530 = tableProductsInsertCommand
					+ "'Булгур', 'Хлебни изделия и зърнени храни', '342', '1', '12', '76', 'гр.', 'веган');";
			dbStatement.executeUpdate(product530);
			String product531 = tableProductsInsertCommand
					+ "'Бутер тесто', 'Хлебни изделия и зърнени храни', '551', '38', '7', '45', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product531);
			String product532 = tableProductsInsertCommand
					+ "'Ванилов пудинг', 'Хлебни изделия и зърнени храни', '130', '4', '2', '22', 'гр.', 'веган');";
			dbStatement.executeUpdate(product532);
			String product533 = tableProductsInsertCommand
					+ "'Галета', 'Хлебни изделия и зърнени храни', '367', '3', '14', '70', 'гр.', 'веган');";
			dbStatement.executeUpdate(product533);
			String product534 = tableProductsInsertCommand
					+ "'Гофрета', 'Хлебни изделия и зърнени храни', '181', '3', '7', '30', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product534);
			String product535 = tableProductsInsertCommand
					+ "'Грис', 'Хлебни изделия и зърнени храни', '360', '1', '13', '73', 'гр.', 'веган');";
			dbStatement.executeUpdate(product535);
			String product536 = tableProductsInsertCommand
					+ "'Елда', 'Хлебни изделия и зърнени храни', '343', '3', '13', '72', 'гр.', 'веган');";
			dbStatement.executeUpdate(product536);
			String product537 = tableProductsInsertCommand
					+ "'Жито', 'Хлебни изделия и зърнени храни', '323', '2.3', '8.4', '65.4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product537);
			String product538 = tableProductsInsertCommand
					+ "'Качамак', 'Хлебни изделия и зърнени храни', '72', '1', '1', '14', 'гр.', 'веган');";
			dbStatement.executeUpdate(product538);
			String product539 = tableProductsInsertCommand
					+ "'Кори за баница', 'Хлебни изделия и зърнени храни', '299', '6', '7', '53', 'гр.', 'веган');";
			dbStatement.executeUpdate(product539);
			String product540 = tableProductsInsertCommand
					+ "'Корнфлейкс', 'Хлебни изделия и зърнени храни', '361', '1', '7', '86', 'гр.', 'веган');";
			dbStatement.executeUpdate(product540);
			String product541 = tableProductsInsertCommand
					+ "'Крутони', 'Хлебни изделия и зърнени храни', '407', '7', '12', '74', 'гр.', 'веган');";
			dbStatement.executeUpdate(product541);
			String product542 = tableProductsInsertCommand
					+ "'Кускус', 'Хлебни изделия и зърнени храни', '376', '1', '13', '77', 'гр.', 'веган');";
			dbStatement.executeUpdate(product542);
			String product543 = tableProductsInsertCommand
					+ "'Макарони', 'Хлебни изделия и зърнени храни', '371', '2', '13', '75', 'гр.', 'веган');";
			dbStatement.executeUpdate(product543);
			String product544 = tableProductsInsertCommand
					+ "'Нишесте', 'Хлебни изделия и зърнени храни', '381', '0', '0', '91', 'гр.', 'веган');";
			dbStatement.executeUpdate(product544);
			String product545 = tableProductsInsertCommand
					+ "'Овесени трици', 'Хлебни изделия и зърнени храни', '403', '7.0', '17.0', '66.0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product545);
			String product546 = tableProductsInsertCommand
					+ "'Овесени ядки', 'Хлебни изделия и зърнени храни', '392', '7.5', '13.0', '66.0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product546);
			String product547 = tableProductsInsertCommand
					+ "'Ориз', 'Хлебни изделия и зърнени храни', '365', '1', '7', '80', 'гр.', 'веган');";
			dbStatement.executeUpdate(product547);
			String product548 = tableProductsInsertCommand
					+ "'Ориз - бял', 'Хлебни изделия и зърнени храни', '355', '0.5', '6.5', '79.0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product548);
			String product549 = tableProductsInsertCommand
					+ "'Ориз - кафяв', 'Хлебни изделия и зърнени храни', '372', '2.7', '7.9', '77.0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product549);
			String product550 = tableProductsInsertCommand
					+ "'Оризови спагети', 'Хлебни изделия и зърнени храни', '351', '0', '0', '86', 'гр.', 'веган');";
			dbStatement.executeUpdate(product550);
			String product551 = tableProductsInsertCommand
					+ "'Оризово брашно', 'Хлебни изделия и зърнени храни', '366', '1', '6', '80', 'гр.', 'веган');";
			dbStatement.executeUpdate(product551);
			String product552 = tableProductsInsertCommand
					+ "'Паста', 'Хлебни изделия и зърнени храни', '371', '2', '13', '75', 'гр.', 'веган');";
			dbStatement.executeUpdate(product552);
			String product553 = tableProductsInsertCommand
					+ "'Просо', 'Хлебни изделия и зърнени храни', '381', '4.2', '11.0', '72.8', 'гр.', 'веган');";
			dbStatement.executeUpdate(product553);
			String product554 = tableProductsInsertCommand
					+ "'Пудинг (смес)', 'Хлебни изделия и зърнени храни', '369', '0', '0', '94', 'гр.', 'веган');";
			dbStatement.executeUpdate(product554);
			String product555 = tableProductsInsertCommand
					+ "'Пшеница', 'Хлебни изделия и зърнени храни', '350', '1.8', '14.0', '67.4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product555);
			String product556 = tableProductsInsertCommand
					+ "'Пшенични трици', 'Хлебни изделия и зърнени храни', '368', '4.5', '15.5', '64.0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product556);
			String product557 = tableProductsInsertCommand
					+ "'Пълнозърнест хляб', 'Хлебни изделия и зърнени храни', '246', '4', '10', '46', 'гр.', 'веган');";
			dbStatement.executeUpdate(product557);
			String product558 = tableProductsInsertCommand
					+ "'Ръж', 'Хлебни изделия и зърнени храни', '352', '1.8', '10.0', '72.1', 'гр.', 'веган');";
			dbStatement.executeUpdate(product558);
			String product559 = tableProductsInsertCommand
					+ "'Ръжен хляб', 'Хлебни изделия и зърнени храни', '250', '3', '9', '48', 'гр.', 'веган');";
			dbStatement.executeUpdate(product559);
			String product560 = tableProductsInsertCommand
					+ "'Соя', 'Хлебни изделия и зърнени храни', '277', '2.7', '36.9', '24.9', 'гр.', 'веган');";
			dbStatement.executeUpdate(product560);
			String product561 = tableProductsInsertCommand
					+ "'Спагети', 'Хлебни изделия и зърнени храни', '371', '2', '13', '75', 'гр.', 'веган');";
			dbStatement.executeUpdate(product561);
			String product562 = tableProductsInsertCommand
					+ "'Сусамово брашно', 'Хлебни изделия и зърнени храни', '333', '2', '50', '36', 'гр.', 'веган');";
			dbStatement.executeUpdate(product562);
			String product563 = tableProductsInsertCommand
					+ "'Сухари', 'Хлебни изделия и зърнени храни', '392', '5.2', '10.8', '73.3', 'гр.', 'веган');";
			dbStatement.executeUpdate(product563);
			String product564 = tableProductsInsertCommand
					+ "'Фасул', 'Хлебни изделия и зърнени храни', '336', '1.5', '23.3', '55.5', 'гр.', 'веган');";
			dbStatement.executeUpdate(product564);
			String product565 = tableProductsInsertCommand
					+ "'Франзела', 'Хлебни изделия и зърнени храни', '274', '3', '9', '52', 'гр.', 'веган');";
			dbStatement.executeUpdate(product565);
			String product566 = tableProductsInsertCommand
					+ "'Хлебни трохи', 'Хлебни изделия и зърнени храни', '395', '5', '12', '72', 'гр.', 'веган');";
			dbStatement.executeUpdate(product566);
			String product567 = tableProductsInsertCommand
					+ "'Хляб', 'Хлебни изделия и зърнени храни', '248', '3', '9', '48', 'гр.', 'веган');";
			dbStatement.executeUpdate(product567);
			String product568 = tableProductsInsertCommand
					+ "'Хляб бял', 'Хлебни изделия и зърнени храни', '249', '1.1', '7.1', '51.4', 'гр.', 'веган');";
			dbStatement.executeUpdate(product568);
			String product569 = tableProductsInsertCommand
					+ "'Хляб ръжен', 'Хлебни изделия и зърнени храни', '235', '1.2', '6.8', '48.0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product569);
			String product570 = tableProductsInsertCommand
					+ "'Хляб типов', 'Хлебни изделия и зърнени храни', '236', '1.7', '8.0', '46.0', 'гр.', 'веган');";
			dbStatement.executeUpdate(product570);
			String product571 = tableProductsInsertCommand
					+ "'Царевица от консерва', 'Хлебни изделия и зърнени храни', '64', '0', '2', '15', 'гр.', 'веган');";
			dbStatement.executeUpdate(product571);
			String product572 = tableProductsInsertCommand
					+ "'Царевично брашно', 'Хлебни изделия и зърнени храни', '365', '4', '9', '76', 'гр.', 'веган');";
			dbStatement.executeUpdate(product572);
			String product573 = tableProductsInsertCommand
					+ "'Черен ориз', 'Хлебни изделия и зърнени храни', '388', '3', '8', '81', 'гр.', 'веган');";
			dbStatement.executeUpdate(product573);
			String product574 = tableProductsInsertCommand
					+ "'Бадеми', 'Ядки', '578', '51', '21', '20  (10ф)', 'гр.', 'веган');";
			dbStatement.executeUpdate(product574);
			String product575 = tableProductsInsertCommand
					+ "'Кайсиеви ядки', 'Ядки', '582', '52', '21', '18', 'гр.', 'веган');";
			dbStatement.executeUpdate(product575);
			String product576 = tableProductsInsertCommand
					+ "'Кашу', 'Ядки', '553', '44', '18', '30 (3ф)', 'гр.', 'веган');";
			dbStatement.executeUpdate(product576);
			String product577 = tableProductsInsertCommand
					+ "'Кедрови ядки', 'Ядки', '566', '51', '24', '14', 'гр.', 'веган');";
			dbStatement.executeUpdate(product577);
			String product578 = tableProductsInsertCommand
					+ "'Лешник', 'ядки', '628', '61', '15', '17', 'гр.', 'веган');";
			dbStatement.executeUpdate(product578);
			String product579 = tableProductsInsertCommand
					+ "'Лешници', 'Ядки', '646', '62', '15', '18 (10ф)', 'гр.', 'веган');";
			dbStatement.executeUpdate(product579);
			String product580 = tableProductsInsertCommand
					+ "'Орех', 'ядки', '654', '65', '15', '14', 'гр.', 'веган');";
			dbStatement.executeUpdate(product580);
			String product581 = tableProductsInsertCommand
					+ "'Орехи', 'Ядки', '654', '65', '15', '14 (7ф)', 'гр.', 'веган');";
			dbStatement.executeUpdate(product581);
			String product582 = tableProductsInsertCommand
					+ "'Слънчогледови семки', 'ядки', '570', '50', '23', '19', 'гр.', 'веган');";
			dbStatement.executeUpdate(product582);
			String product583 = tableProductsInsertCommand
					+ "'Фъстък', 'ядки', '567', '49', '26', '16', 'гр.', 'веган');";
			dbStatement.executeUpdate(product583);
			String product584 = tableProductsInsertCommand
					+ "'Фъстъци', 'Ядки', '567', '49', '26', '16 (9ф)', 'гр.', 'веган');";
			dbStatement.executeUpdate(product584);
			String product585 = tableProductsInsertCommand
					+ "'Шам-фъстък', 'Ядки', '557', '44', '21', '28 (10ф )', 'гр.', 'веган');";
			dbStatement.executeUpdate(product585);
			String product586 = tableProductsInsertCommand
					+ "'Белтък', 'Яйчен продукт', '50', '0', '11', '1', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product586);
			String product587 = tableProductsInsertCommand
					+ "'Белтък 1 бр', 'Яйчен продукт', '17', '0', '4', '0', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product587);
			String product588 = tableProductsInsertCommand
					+ "'Жълтък', 'Яйчен продукт', '358', '31', '17', '2', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product588);
			String product589 = tableProductsInsertCommand
					+ "'Жълтък 1 бр', 'Яйчен продукт', '55', '5', '3', '1', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product589);
			String product590 = tableProductsInsertCommand
					+ "'Майонеза', 'Яйчен продукт', '333', '33', '1', '7', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product590);
			String product591 = tableProductsInsertCommand
					+ "'Яйце', 'Яйчен продукт', '149', '10', '12', '1', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product591);
			String product592 = tableProductsInsertCommand
					+ "'Яйце - гъше', 'Яйчен продукт', '185', '13.5', '13.9', '1.3', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product592);
			String product593 = tableProductsInsertCommand
					+ "'Яйце - кокоше', 'Яйчен продукт', '157', '11.2', '12.9', '0.7', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product593);
			String product594 = tableProductsInsertCommand
					+ "'Яйце - пуешко', 'Яйчен продукт', '166', '11.7', '13.5', '1.1', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product594);
			String product595 = tableProductsInsertCommand
					+ "'Яйце 1 бр (58 гр)', 'Яйчен продукт', '84', '6', '7', '0', 'бр.', 'вегетарианско');";
			dbStatement.executeUpdate(product595);
			String product596 = tableProductsInsertCommand
					+ "'Яйчен белтък - кокоши', 'Яйчен продукт', '54', '0.7', '11.1', '0.7', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product596);
			String product597 = tableProductsInsertCommand
					+ "'Яйчен жалтък - кокоши', 'Яйчен продукт', '849', '81.9', '16.1', '9.3', 'гр.', 'вегетарианско');";
			dbStatement.executeUpdate(product597);
			String product598 = tableProductsInsertCommand
					+ "'Яйчен ликьор', 'Яйчен продукт', '276', '0', '0', '39', 'мл.', 'вегетарианско');";
			dbStatement.executeUpdate(product598);

		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
}
