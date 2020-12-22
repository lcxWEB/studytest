package com.star;

import com.star.util.JsonUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringTest {


    public static void main(String[] args) {
        String str = "测试的身份";

        str.getBytes();


        // String original = "archives_name, archives_identifier, fonds_name, fonds_constituting_unit_name, electronic_record_code, archival_code, fonds_identifier, catalogue_number, year, retention_period, organizational_structure_or_function, file_number, item_number, document_sequence_number, page_number, title, parallel_title, alternative_title, other_title_information, descriptor, keyword, personal_name, file_abstract, class_code, document_number, author, date, document_type, precedence, principal_receiver, other_receivers, security_classification, secrecy_period, document_aggregation, total_number_of_items, total_number_of_pages, language, manuscript_type, annotation, organization_code, end_page_number, attachment_count, begin_date, end_date, department, department_code, submitter, other_author, begin_and_end_date, medium, publication, innerfile_sequence_number, uuid, relation_uuid, state, is_delete, create_time, update_time, submit_user_name, pre_archival_code, is_open, archival_date, box_number, appraise_state, voucher_number, photos_group_sequence_number, photos_group_description, related_records_identifier, photos_group_page_count, photographer, photograph_department, storage_location, medium_identifier, electronic_file_format, photo_description, photo_sequence_number, creation_date, negative_number, category_level1_code, category_level2_code, category_level3_code, category_level4_code, category_level5_code, category_level6_code, leaf_category_code, archive_scope_code, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e29, e30";
        // String original ="id, fonds_name, fonds_constituting_unit_name, archival_code, pre_archival_code, fonds_identifier, catalogue_number, year, retention_period, organizational_structure_or_function, item_number, file_number, total_number_of_items, page_number, end_page_number, total_number_of_pages, title, alternative_title, descriptor, document_number, author, other_author, date, begin_end_date, begin_date, end_date, document_type, security_classification, manuscript_type, annotation, medium, publication, control_identifier, archival_date, box_number, storage_location, medium_identifier, submitter, electronic_file_format, electronic_file_url, photographer, photograph_department, related_records_identifier, duration, award_organization, grade, voucher_number, category_level1_code, category_level2_code, category_level3_code, category_level4_code, category_level5_code, category_level6_code, leaf_category_code, archive_scope_code, attachment_count, department, department_code, uuid, relation_uuid, state, appraise_state, is_delete, create_time, update_time, submit_user_name, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e1000h_1, e1000h_2, e1000h_3, e255h_1, e255h_2, e255h_3, e255h_4, e255h_5, e255h_6, e255h_7, e255h_8, e255h_9, e255h_10, e255h_11, e255h_12, e255h_13, e255h_14, e255h_16, e255h_17, e255h_18, e255h_19, e255h_20, e100h_1, e100h_2, e100h_3, e100h_4, e100h_5, e100h_6, e100h_7, e100h_8, e100h_9, e100h_10, e100h_11, e100h_12, e100h_13, e100h_14, e100h_15, e100h_16, e100h_17, e100h_18, e100h_19, e100h_20, e50h_1, e50h_2, e50h_3, e50h_4, e50h_5, e50h_6, e50h_7, e50h_8, e50h_9, e50h_10, e50h_11, e50h_12, e50h_13, e50h_14, e50h_15, e50h_16, e50h_17, e50h_18, e50h_19, e50h_20, e_time_1, e_time_2, e_time_3, e_time_4, e_time_5, e_time_6, e_time_7, e_time_8, e_time_9, e_time_10, e_int_1, e_int_2, e_int_3, e_int_4, e_int_5, e_int_6, e_int_7, e_int_8, e_int_9, e_int_10, e_int_11, e_int_12, e_int_13, e_int_14, e_int_15, e_int_16, e_int_17, e_int_18, e_int_19, e_int_20";
        System.out.println(LocalDateTime.now());
        String original = "id, fonds_name, fonds_identifier, pre_archival_code, archival_code, year, retention_period, sequence_number, total_number_of_items, begin_sequence_number, end_sequence_number, title, author, date, begin_date, end_date, archival_date, annotation, medium, medium_identifier, submitter, efile_name, format, file_size, img_url, efile_save_path, producer, place, width, height, resolution, img_dpi, duration, bit_rate, frames_per_second, related_records_identifier, tag_category, category_level1_code, category_level2_code, category_level3_code, category_level4_code, category_level5_code, category_level6_code, leaf_category_code, department, department_code, uuid, relation_uuid, state, transcode_state, create_time, update_time, submit_user_name, submit_date, e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e1000h_1, e1000h_2, e1000h_3, e255h_1, e255h_2, e255h_3, e255h_4, e255h_5, e255h_6, e255h_7, e255h_8, e255h_9, e255h_10, e255h_11, e255h_12, e255h_13, e255h_14, e255h_16, e255h_17, e255h_18, e255h_19, e255h_20, e100h_1, e100h_2, e100h_3, e100h_4, e100h_5, e100h_6, e100h_7, e100h_8, e100h_9, e100h_10, e100h_11, e100h_12, e100h_13, e100h_14, e100h_15, e100h_16, e100h_17, e100h_18, e100h_19, e100h_20, e50h_1, e50h_2, e50h_3, e50h_4, e50h_5, e50h_6, e50h_7, e50h_8, e50h_9, e50h_10, e50h_11, e50h_12, e50h_13, e50h_14, e50h_15, e50h_16, e50h_17, e50h_18, e50h_19, e50h_20, e_time_1, e_time_2, e_time_3, e_time_4, e_time_5, e_time_6, e_time_7, e_time_8, e_time_9, e_time_10, e_int_1, e_int_2, e_int_3, e_int_4, e_int_5, e_int_6, e_int_7, e_int_8, e_int_9, e_int_10, e_int_11, e_int_12, e_int_13, e_int_14, e_int_15, e_int_16, e_int_17, e_int_18, e_int_19, e_int_20";
        String[] strArr1 = original.split(",");
        System.out.println(strArr1.length);
        String source = "#{file.categoryId}, #{file.archivesName}, #{file.archivesIdentifier},\n" +
                "            #{file.fondsName},#{file.fondsConstitutingUnitName},\n" +
                "            #{file.electronicRecordCode}, #{file.archivalCode}, #{file.fondsIdentifier}, #{file.catalogueNumber},\n" +
                "            #{file.year},\n" +
                "            #{file.retentionPeriod}, #{file.organizationalStructureOrFunction}, #{file.categoryCode},\n" +
                "            #{file.fileNumber},\n" +
                "            #{file.itemNumber}, #{file.documentSequenceNumber}, #{file.pageNumber}, #{file.title},\n" +
                "            #{file.parallelTitle},\n" +
                "            #{file.alternativeTitle}, #{file.otherTitleInformation}, #{file.descriptor}, #{file.keyword},\n" +
                "            #{file.personalName},\n" +
                "            #{file.fileAbstract}, #{file.classCode}, #{file.documentNumber}, #{file.author}, #{file.date},\n" +
                "            #{file.documentType},\n" +
                "            #{file.precedence}, #{file.principalReceiver}, #{file.otherReceivers}, #{file.securityClassification},\n" +
                "            #{file.secrecyPeriod}, #{file.documentAggregation}, #{file.totalNumberOfItems}, #{file.totalNumberOfPages},\n" +
                "            #{file.language}, #{file.manuscriptType}, #{file.annotation}, #{file.organizationCode},\n" +
                "            #{file.endPageNumber},\n" +
                "            #{file.attachmentCount}, #{file.beginDate}, #{file.endDate}, #{file.department}, #{file.departmentCode},\n" +
                "            #{file.submitter}, #{file.otherAuthor}, #{file.beginAndEndDate}, #{file.medium}, #{file.publication},\n" +
                "            #{file.innerfileSequenceNumber}, #{file.innerfileCount}, #{file.uuid}, #{file.relationUuid},\n" +
                "            #{file.state}, #{file.isDelete}, #{file.createTime}, #{file.e1}, #{file.e2}, #{file.e3}, #{file.e4},\n" +
                "            #{file.e5}, #{file.e6}, #{file.e7}, #{file.e8}, #{file.e9}, #{file.e10}, #{file.e11}, #{file.e12},\n" +
                "            #{file.e13}, #{file.e14}, #{file.e15}, #{file.e16}, #{file.e17}, #{file.e18}, #{file.e19}, #{file.e20},\n" +
                "            #{file.e21}, #{file.e22}, #{file.e23}, #{file.e24}, #{file.e25}, #{file.e26}, #{file.e27}, #{file.e28},\n" +
                "            #{file.e29}, #{file.e30}, #{file.e31}, #{file.e32}, #{file.e33}, #{file.e34}, #{file.e35}, #{file.e36},\n" +
                "            #{file.e37}, #{file.e38}, #{file.e39}, #{file.e40}, #{file.e41}, #{file.e42}, #{file.e43}, #{file.e44},\n" +
                "            #{file.e45}, #{file.e46}, #{file.e47}, #{file.e48}, #{file.e49}, #{file.e50}";

        String[] strArr = source.split("},");
        System.out.println(strArr.length);
        String[] originals = original.split(",");
        List<String> collect = Arrays.stream(originals).map(s -> s = "#{file." + JsonUtils.camelName(s.trim()) + "}").collect(Collectors.toList());
        List<String> collect1 = Arrays.stream(originals).map(s -> s = "<if test=\"file." + JsonUtils.camelName(s.trim()) + " != null\">" + s.trim() + "=#{file." + JsonUtils.camelName(s.trim()) + "}, </if>").collect(Collectors.toList());
//        System.out.println(Arrays.toString(originals));
        System.out.println(collect);
        System.out.println(collect1);

        Map<String, String> map = new HashMap<>();
        map.put("test", "dsdsdsd");
        map.put(null, "dsdsd");
        map.put(null, "AAAAA");
        System.out.println(map);
        map.forEach((s, s2) -> System.out.println(s + " : " + s2));
        System.out.println(map);

        System.out.println(11 / 10);

        String s = "SsS";
        String s2 = "SsS";
        String ns = new String("SsS");
        String n = s.toUpperCase();
        System.out.println(s.equals("SsS"));
        System.out.println(s == ns);
        System.out.println("s.intern() == ns.intern()  " + ("yyy".intern() == "yyy".intern()));
        System.out.println(s.intern() == ns.intern());
        System.out.println(s.toCharArray() == ns.toCharArray());
        System.out.println("iii" == "iii");
        System.out.println(s == s2);

        System.out.println(new StringTest());
        try {
            Class<?> cc = Class.forName("com.star.StringTest");
            System.out.println(cc.getName());
            System.out.println(cc.getSimpleName());
            System.out.println(cc.getCanonicalName());
            System.out.println(cc.isInterface());
            System.out.println(cc.getInterfaces());
            System.out.println("super : " + cc.getSuperclass());
            Object o = cc.newInstance();
            System.out.println(o.getClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        double x = (double) 11 / 12;
        System.out.println(x);
    }


    @Override
    public String toString() {
//        return "class " + this;
        return super.toString();
    }
}
