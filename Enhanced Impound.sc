SCRIPT_START
{
LVAR_INT scplayer 
LVAR_INT player_car car_model parked_car parking_blip
LVAR_INT primary_color secondary_color paintjob
LVAR_INT component_0 component_1 component_2 component_3 component_4 component_5 component_6 component_7 component_8 component_9 component_10 component_11 component_12 component_13 component_14 component_15 component_save
LVAR_INT town_number police_flag wait_flag_save
LVAR_FLOAT position_temp position_z car_heading

GET_PLAYER_CHAR 0 scplayer
player_car = -1
parking_blip = -1

CONST_INT wait_exit 1
CONST_INT wait_delete 2


main_loop:
WAIT 0
IF IS_PLAYER_PLAYING 0

    //Activate save vehicle flag
    IF IS_CHAR_IN_ANY_CAR scplayer
    AND NOT IS_CHAR_IN_ANY_BOAT scplayer
    AND NOT IS_CHAR_IN_ANY_HELI scplayer
    AND NOT IS_CHAR_IN_ANY_PLANE scplayer
    AND NOT IS_CHAR_IN_ANY_POLICE_VEHICLE scplayer
    AND NOT IS_CHAR_IN_TAXI scplayer
    AND NOT IS_CHAR_IN_ANY_TRAIN scplayer

        IF LOCATE_CHAR_ANY_MEANS_2D scplayer 2506.144 -1694.9114 4.0 4.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer 1354.5602 -629.533 4.0 4.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer 1698.8307 -2084.7788 4.0 4.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer 322.5228 -1765.8087 4.0 4.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer 786.1149 -489.6591 4.0 4.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer 2230.2971 171.4781 4.0 4.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer -2447.4412 -122.1891 6.0 6.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer -2105.1846 893.1396 4.0 4.0 FALSE //done
            IF NOT wait_flag_save = wait_exit
                wait_flag_save = wait_exit
                WRITE_DEBUG CAR_SAVE_FLAG
                GOSUB save_car
            ENDIF
            
        ELSE
            IF LOCATE_CHAR_ANY_MEANS_2D scplayer -2696.2268 825.5031 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer -360.8223 1198.1362 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer 436.3296 2546.2886 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer 932.7431 2011.7924 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer 1273.8107 2529.6082 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer 1412.1777 1902.241 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer 2452.2976 697.8154 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer -2026.7955 123.9065 4.0 4.0 FALSE //done
                IF NOT wait_flag_save = wait_exit
                    wait_flag_save = wait_exit
                    WRITE_DEBUG CAR_SAVE_FLAG
                    GOSUB save_car
                ENDIF
            ENDIF
        ENDIF
    ENDIF

    //Save vehicle
    IF wait_flag_save = wait_exit
    AND NOT IS_CHAR_IN_CAR scplayer player_car
        GET_CITY_PLAYER_IS_IN 0 town_number
        police_flag = 0
        wait_flag_save = wait_delete
        WRITE_DEBUG CAR_DELETE_FLAG
    ENDIF

    //Return to wait_exit
    IF wait_flag_save = wait_delete
    AND IS_CHAR_IN_CAR scplayer player_car
        wait_flag_save = wait_exit
        WRITE_DEBUG CAR_RETURN_SAVE_FLAG
    ENDIF

    //Unsave Vehicle
    IF DOES_VEHICLE_EXIST player_car
    AND NOT IS_CHAR_IN_ANY_CAR scplayer
        IF LOCATE_CHAR_ANY_MEANS_2D scplayer 2506.144 -1694.9114 4.0 4.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer 1354.5602 -629.533 4.0 4.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer 1698.8307 -2084.7788 4.0 4.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer 322.5228 -1765.8087 4.0 4.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer 786.1149 -489.6591 4.0 4.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer 2230.2971 171.4781 4.0 4.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer -2447.4412 -122.1891 6.0 6.0 FALSE //done
        OR LOCATE_CHAR_ANY_MEANS_2D scplayer -2105.1846 893.1396 4.0 4.0 FALSE //done
            player_car = -1
            WRITE_DEBUG CAR_CLEAR_FLAG
        ELSE
            IF LOCATE_CHAR_ANY_MEANS_2D scplayer -2696.2268 825.5031 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer -360.8223 1198.1362 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer 436.3296 2546.2886 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer 932.7431 2011.7924 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer 1273.8107 2529.6082 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer 1412.1777 1902.241 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer 2452.2976 697.8154 4.0 4.0 FALSE //done
            OR LOCATE_CHAR_ANY_MEANS_2D scplayer -2026.7955 123.9065 4.0 4.0 FALSE //done
                player_car = -1
                WRITE_DEBUG CAR_CLEAR_FLAG
            ENDIF
        ENDIF
    ENDIF

    //Debug Delete
    IF IS_PS2_KEYBOARD_KEY_JUST_PRESSED 49 // 1
        IF DOES_VEHICLE_EXIST player_car
            DELETE_CAR player_car
        ENDIF
    ENDIF

    //Debug Teleport
    IF IS_PS2_KEYBOARD_KEY_JUST_PRESSED 50 //2
        SET_CHAR_COORDINATES scplayer 2218.06 2448.06 -6.43807
    ENDIF

    //Debug Clear prints
    IF IS_PS2_KEYBOARD_KEY_JUST_PRESSED 51 //3
        CLEAR_ALL_VIEW_VARIABLES
    ENDIF

    //Car confiscation
    IF NOT player_car = -1
    AND NOT DOES_VEHICLE_EXIST player_car
        police_flag = 1
        SWITCH town_number
            CASE 0
            CASE 1
                PRINT_HELP IMP_CL1
                BREAK
            CASE 2
                PRINT_HELP IMP_CL2
                BREAK
            CASE 3
                PRINT_HELP IMP_CL3
                BREAK 
        ENDSWITCH
        player_car = -1
    ENDIF

    //Create LSPD blip
    IF police_flag = 1
    AND town_number > 0
    AND NOT town_number = 2
    AND LOCATE_CHAR_ANY_MEANS_2D scplayer 1540.1239 -1647.3964 120.0 120.0 FALSE
    AND parking_blip = -1
        ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD 1544.8322 -1645.1257 5.8906 55 parking_blip
        WRITE_DEBUG CREATE_LSPD_BLIP
    ENDIF

    //Create SFPD blip
    IF police_flag = 1
    AND town_number = 2
    AND LOCATE_CHAR_ANY_MEANS_2D scplayer -1622.9957 659.543 120.0 120.0 FALSE
    AND parking_blip = -1
        ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD -1622.9957 659.543 -5.2422 55 parking_blip
        WRITE_DEBUG CREATE_SFPD_BLIP

    ENDIF

    //Create LVPD blip
    IF police_flag = 1
    AND town_number = 3
    AND LOCATE_CHAR_ANY_MEANS_2D scplayer 2224.8313 2457.9363 120.0 120.0 FALSE
    AND parking_blip = -1
        ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD 2224.8313 2457.9363 -7.4531 55 parking_blip
        WRITE_DEBUG CREATE_LVPD_BLIP

    ENDIF

    //Delete LSPD blip
    IF NOT parking_blip = -1
    AND town_number > 0
    AND NOT town_number = 2
    AND NOT LOCATE_CHAR_ANY_MEANS_2D scplayer 1540.1239 -1647.3964 120.0 120.0 FALSE
        REMOVE_BLIP parking_blip
        WRITE_DEBUG REMOVE_LSPD_BLIP
        parking_blip = -1
    ENDIF

    //Delete SFPD blip
    IF NOT parking_blip = -1
    AND town_number = 2
    AND NOT LOCATE_CHAR_ANY_MEANS_2D scplayer -1622.9957 659.543 120.0 120.0 FALSE
        REMOVE_BLIP parking_blip
        parking_blip = -1
        WRITE_DEBUG REMOVE_SFPD_BLIP
    ENDIF

    //Delete LVPD blip
    IF NOT parking_blip = -1
    AND town_number = 3
    AND NOT LOCATE_CHAR_ANY_MEANS_2D scplayer 2224.8313 2457.9363 120.0 120.0 FALSE
        REMOVE_BLIP parking_blip
        parking_blip = -1
        WRITE_DEBUG REMOVE_LVPD_BLIP
    ENDIF

    //LSPD Create
    GET_CHAR_COORDINATES scplayer position_temp position_temp position_z
    IF LOCATE_CHAR_ANY_MEANS_2D scplayer 1540.1239 -1647.3964 60.0 60.0 FALSE
    AND position_z < 7.0
        CLEAR_AREA 1540.1239 -1647.3964 5.8906 10.0 TRUE
        
        IF police_flag = 1
        AND town_number > 0
        AND NOT town_number = 2
        AND NOT DOES_VEHICLE_EXIST parked_car
            GOSUB create_save_car
            WRITE_DEBUG CAR_CREATED_LS
        ENDIF
    ENDIF

    //Clear car
    IF DOES_VEHICLE_EXIST parked_car
    AND IS_CHAR_IN_CAR scplayer parked_car
        MARK_CAR_AS_NO_LONGER_NEEDED parked_car
        parked_car = -1
        player_car = -1
        police_flag = 0
        WRITE_DEBUG MARK_CAR_AS_NO_LONGER_NEEDED
        wait_flag_save = wait_exit
        WRITE_DEBUG CAR_SAVE_FLAG
        GOSUB save_car
    ENDIF

    //LSPD Delete
    GET_CHAR_COORDINATES scplayer position_temp position_temp position_z
    IF position_z > 7.0
    AND police_flag = 1
    AND town_number > 0
    AND NOT town_number = 2
    AND DOES_VEHICLE_EXIST parked_car
       DELETE_CAR parked_car
       WRITE_DEBUG CAR_DELETED_LS
    ENDIF

    //SFPD Create
    GET_CHAR_COORDINATES scplayer position_temp position_temp position_z
    IF LOCATE_CHAR_ANY_MEANS_2D scplayer -1622.9957 659.543 60.0 60.0 FALSE
    AND position_z < -4.0
        CLEAR_AREA -1631.762 655.8758 -5.2422 10.0 TRUE
        
        IF police_flag = 1
        AND town_number = 2
        AND NOT DOES_VEHICLE_EXIST parked_car
            GOSUB create_save_car
            WRITE_DEBUG CAR_CREATED_SF
        ENDIF
    ENDIF

    //SFPD Delete
    GET_CHAR_COORDINATES scplayer position_temp position_temp position_z
    IF NOT LOCATE_CHAR_ANY_MEANS_2D scplayer -1622.9957 659.543 60.0 60.0 FALSE
    AND position_z > -4.0
    AND police_flag = 1
    AND town_number = 2
    AND DOES_VEHICLE_EXIST parked_car
       DELETE_CAR parked_car
       WRITE_DEBUG CAR_DELETED_SF
    ENDIF

    //LVPD Create
    GET_CHAR_COORDINATES scplayer position_temp position_temp position_z
    IF LOCATE_CHAR_ANY_MEANS_2D scplayer 2224.8313 2457.9363 60.0 60.0 FALSE
    AND position_z < -6.0
        CLEAR_AREA 2224.8313 2457.9363 -7.4531 10.0 TRUE
        IF police_flag = 1
        AND town_number = 3
        AND NOT DOES_VEHICLE_EXIST parked_car
            GOSUB create_save_car
            WRITE_DEBUG CAR_CREATED_LV
        ENDIF
    ENDIF

    //LVPD Delete
    GET_CHAR_COORDINATES scplayer position_temp position_temp position_z
    IF NOT LOCATE_CHAR_ANY_MEANS_2D scplayer 2224.8313 2457.9363 60.0 60.0 FALSE
    AND position_z > -6.0
    AND police_flag = 1
    AND town_number = 3
    AND DOES_VEHICLE_EXIST parked_car
       DELETE_CAR parked_car
       WRITE_DEBUG CAR_DELETED_LV
    ENDIF

ENDIF

GOTO main_loop

save_car:
STORE_CAR_CHAR_IS_IN_NO_SAVE scplayer player_car
GET_CAR_MODEL player_car car_model
GET_CAR_COLOURS player_car primary_color secondary_color
GET_CURRENT_VEHICLE_PAINTJOB player_car paintjob

GET_AVAILABLE_VEHICLE_MOD player_car 0 component_0
IF NOT component_0 = -1
    GET_CURRENT_CAR_MOD player_car 0 component_0
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 1 component_1
IF NOT component_1 = -1
    GET_CURRENT_CAR_MOD player_car 1 component_1
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 2 component_2
IF NOT component_2 = -1
    GET_CURRENT_CAR_MOD player_car 2 component_2
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 3 component_3
IF NOT component_3 = -1
    GET_CURRENT_CAR_MOD player_car 3 component_3
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 4 component_4
IF NOT component_4 = -1
    GET_CURRENT_CAR_MOD player_car 4 component_4
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 5 component_5
IF NOT component_5 = -1
    GET_CURRENT_CAR_MOD player_car 5 component_5
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 6 component_6
IF NOT component_6 = -1
    GET_CURRENT_CAR_MOD player_car 6 component_6
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 7 component_7
IF NOT component_7 = -1
    GET_CURRENT_CAR_MOD player_car 7 component_7
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 8 component_8
IF NOT component_8 = -1
    GET_CURRENT_CAR_MOD player_car 8 component_8
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 9 component_9
IF NOT component_9 = -1
    GET_CURRENT_CAR_MOD player_car 9 component_9
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 10 component_10
IF NOT component_10 = -1
    GET_CURRENT_CAR_MOD player_car 10 component_10
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 11 component_11
IF NOT component_11 = -1
    GET_CURRENT_CAR_MOD player_car 11 component_11
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 12 component_12
IF NOT component_12 = -1
    GET_CURRENT_CAR_MOD player_car 12 component_12
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 13 component_13
IF NOT component_13 = -1
    GET_CURRENT_CAR_MOD player_car 13 component_13
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 14 component_14
IF NOT component_14 = -1
    GET_CURRENT_CAR_MOD player_car 14 component_14
ENDIF
GET_AVAILABLE_VEHICLE_MOD player_car 15 component_15
IF NOT component_15 = -1
    GET_CURRENT_CAR_MOD player_car 15 component_15
ENDIF

RETURN

create_save_car:
REQUEST_MODEL car_model
LOAD_ALL_MODELS_NOW

SWITCH town_number
    CASE 0
    CASE 1
        CREATE_CAR car_model 1544.8322 -1645.1257 5.8906 parked_car
        SET_CAR_HEADING parked_car 182.1599
    BREAK
    CASE 2
        CREATE_CAR car_model -1622.9957 659.543 -5.2422 parked_car
        SET_CAR_HEADING parked_car 94.4785
    BREAK
    CASE 3
        CREATE_CAR car_model 2226.4687 2456.751 -7.4531 parked_car
        SET_CAR_HEADING parked_car 3.825
    BREAK 
ENDSWITCH


CHANGE_CAR_COLOUR parked_car primary_color secondary_color
GIVE_VEHICLE_PAINTJOB parked_car paintjob

IF NOT component_0 = -1
    REQUEST_VEHICLE_MOD component_0
    ADD_VEHICLE_MOD parked_car component_0 component_save   
ENDIF
IF NOT component_1 = -1
    REQUEST_VEHICLE_MOD component_1
    ADD_VEHICLE_MOD parked_car component_1 component_save 
ENDIF
IF NOT component_2 = -1
    REQUEST_VEHICLE_MOD component_2
    ADD_VEHICLE_MOD parked_car component_2 component_save  
ENDIF
IF NOT component_3 = -1
    REQUEST_VEHICLE_MOD component_3
    ADD_VEHICLE_MOD parked_car component_3 component_save 
ENDIF
IF NOT component_4 = -1
    REQUEST_VEHICLE_MOD component_4
    ADD_VEHICLE_MOD parked_car component_4 component_save  
ENDIF
IF NOT component_5 = -1
    REQUEST_VEHICLE_MOD component_5
    ADD_VEHICLE_MOD parked_car component_5 component_save  
ENDIF
IF NOT component_6 = -1
    REQUEST_VEHICLE_MOD component_6
    ADD_VEHICLE_MOD parked_car component_6 component_save 
ENDIF
IF NOT component_7 = -1
    REQUEST_VEHICLE_MOD component_7
    ADD_VEHICLE_MOD parked_car component_7 component_save 
ENDIF
IF NOT component_8 = -1
    REQUEST_VEHICLE_MOD component_8
    ADD_VEHICLE_MOD parked_car component_8 component_save 
ENDIF
IF NOT component_9 = -1
    REQUEST_VEHICLE_MOD component_9
    ADD_VEHICLE_MOD parked_car component_9 component_save 
ENDIF
IF NOT component_10 = -1
    REQUEST_VEHICLE_MOD component_10
    ADD_VEHICLE_MOD parked_car component_10 component_save 
ENDIF
IF NOT component_11 = -1
    REQUEST_VEHICLE_MOD component_11
    ADD_VEHICLE_MOD parked_car component_11 component_save 
ENDIF
IF NOT component_12 = -1
    REQUEST_VEHICLE_MOD component_12
    ADD_VEHICLE_MOD parked_car component_12 component_save
ENDIF
IF NOT component_13 = -1
    REQUEST_VEHICLE_MOD component_13
    ADD_VEHICLE_MOD parked_car component_13 component_save 
ENDIF
IF NOT component_14 = -1
    REQUEST_VEHICLE_MOD component_14
    ADD_VEHICLE_MOD parked_car component_14 component_save 
ENDIF
IF NOT component_15 = -1
    REQUEST_VEHICLE_MOD component_15
    ADD_VEHICLE_MOD parked_car component_15 component_save 
ENDIF
RETURN
}
SCRIPT_END