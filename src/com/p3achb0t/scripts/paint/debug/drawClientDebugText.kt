package com.p3achb0t.scripts.paint.debug

import com.p3achb0t.api.Context
import com.p3achb0t.api.LoginResponse
import com.p3achb0t.api.wrappers.utils.Calculations
import java.awt.Color
import java.awt.Font
import java.awt.Graphics



fun drawClientDebugText(g: Graphics, ctx: Context) {

    val debugText = arrayListOf<DebugText>()
    if (true) {

        g.color = Color.white
        debugText.add(DebugText("get__y_ny      : ${ctx.client.get__y_ny()}"))
        debugText.add(DebugText("get__p_rk      : ${ctx.client.get__p_rk()}"))
        debugText.add(DebugText("get__j_an      : ${ctx.client.get__j_an()}"))
        debugText.add(DebugText("get__l_tn      : ${ctx.client.get__l_tn()}"))
        debugText.add(DebugText("get__g_l       : ${ctx.client.get__g_l()}"))
        debugText.add(DebugText("get__k_ie      : ${ctx.client.get__k_ie()}"))
        debugText.add(DebugText("get__m_re      : ${ctx.client.get__m_re()}"))
        debugText.add(DebugText("get__m_rf      : ${ctx.client.get__m_rf()}"))
        debugText.add(DebugText("get__z_es      : ${ctx.client.get__z_es()}"))
        debugText.add(DebugText("get__ap_eh     : ${ctx.client.get__ap_eh()}"))
        debugText.add(DebugText("get__as_ra     : ${ctx.client.get__as_ra()}"))
        debugText.add(DebugText("get__az_cb     : ${ctx.client.get__az_cb()}"))
        debugText.add(DebugText("get__az_ce     : ${ctx.client.get__az_ce()}"))
        debugText.add(DebugText("get__az_ch     : ${ctx.client.get__az_ch()}"))
        debugText.add(DebugText("get__az_cj     : ${ctx.client.get__az_cj()}"))
        debugText.add(DebugText("get__az_ck     : ${ctx.client.get__az_ck()}"))
        debugText.add(DebugText("get__az_cy     : ${ctx.client.get__az_cy()}"))
        debugText.add(DebugText("get__ac_tf     : ${ctx.client.get__ac_tf()}"))
        debugText.add(DebugText("get__af_a      : ${ctx.client.get__af_a()}"))
        debugText.add(DebugText("get__af_d      : ${ctx.client.get__af_d()}"))
        debugText.add(DebugText("get__af_e      : ${ctx.client.get__af_e()}"))
        debugText.add(DebugText("get__af_f      : ${ctx.client.get__af_f()}"))
        debugText.add(DebugText("get__af_s      : ${ctx.client.get__af_s()}"))
        debugText.add(DebugText("get__bu_rw     : ${ctx.client.get__bu_rw()}"))
        debugText.add(DebugText("get__be_mm     : ${ctx.client.get__be_mm()}"))
        debugText.add(DebugText("get__bj_d      : ${ctx.client.get__bj_d()}"))
        debugText.add(DebugText("get__bn_gh     : ${ctx.client.get__bn_gh()}"))
        debugText.add(DebugText("get__bb_o      : ${ctx.client.get__bb_o()}"))
        debugText.add(DebugText("get__bk_gw     : ${ctx.client.get__bk_gw()}"))
        debugText.add(DebugText("get__client_tr : ${ctx.client.get__client_tr()}"))
        debugText.add(DebugText("get__client_be : ${ctx.client.get__client_be()}"))
        debugText.add(DebugText("get__client_cc : ${ctx.client.get__client_cc()}"))
        debugText.add(DebugText("get__client_cj : ${ctx.client.get__client_cj()}"))
        debugText.add(DebugText("get__client_df : ${ctx.client.get__client_df()}"))
        debugText.add(DebugText("get__client_dv : ${ctx.client.get__client_dv()}"))
        debugText.add(DebugText("get__client_ej : ${ctx.client.get__client_ej()}"))
        debugText.add(DebugText("get__client_el : ${ctx.client.get__client_el()}"))
        debugText.add(DebugText("get__client_et : ${ctx.client.get__client_et()}"))
        debugText.add(DebugText("get__client_fb : ${ctx.client.get__client_fb()}"))
        debugText.add(DebugText("get__client_fg : ${ctx.client.get__client_fg()}"))
        debugText.add(DebugText("get__client_gb : ${ctx.client.get__client_gb()}"))
        debugText.add(DebugText("get__client_gm : ${ctx.client.get__client_gm()}"))
        debugText.add(DebugText("get__client_gp : ${ctx.client.get__client_gp()}"))
        debugText.add(DebugText("get__client_gs : ${ctx.client.get__client_gs()}"))
        debugText.add(DebugText("get__client_gv : ${ctx.client.get__client_gv()}"))
        debugText.add(DebugText("get__client_gz : ${ctx.client.get__client_gz()}"))
        debugText.add(DebugText("get__client_hh : ${ctx.client.get__client_hh()}"))
        debugText.add(DebugText("get__client_hi : ${ctx.client.get__client_hi()}"))
        debugText.add(DebugText("get__client_hk : ${ctx.client.get__client_hk()}"))
        debugText.add(DebugText("get__client_hm : ${ctx.client.get__client_hm()}"))
        debugText.add(DebugText("get__client_hn : ${ctx.client.get__client_hn()}"))
        debugText.add(DebugText("get__client_hp : ${ctx.client.get__client_hp()}"))
        debugText.add(DebugText("get__client_ht : ${ctx.client.get__client_ht()}"))
        debugText.add(DebugText("get__client_hx : ${ctx.client.get__client_hx()}"))
        debugText.add(DebugText("get__client_hz : ${ctx.client.get__client_hz()}"))
        debugText.add(DebugText("get__client_ig : ${ctx.client.get__client_ig()}"))
        debugText.add(DebugText("get__client_ii : ${ctx.client.get__client_ii()}"))
        debugText.add(DebugText("get__client_ik : ${ctx.client.get__client_ik()}"))
        debugText.add(DebugText("get__client_il : ${ctx.client.get__client_il()}"))
        debugText.add(DebugText("get__client_io : ${ctx.client.get__client_io()}"))
        debugText.add(DebugText("get__client_ip : ${ctx.client.get__client_ip()}"))
        debugText.add(DebugText("get__client_ir : ${ctx.client.get__client_ir()}"))
        debugText.add(DebugText("get__client_is : ${ctx.client.get__client_is()}"))
        debugText.add(DebugText("get__client_iu : ${ctx.client.get__client_iu()}"))
        debugText.add(DebugText("get__client_jc : ${ctx.client.get__client_jc()}"))
        debugText.add(DebugText("get__client_jf : ${ctx.client.get__client_jf()}"))
        debugText.add(DebugText("get__client_jt : ${ctx.client.get__client_jt()}"))
        debugText.add(DebugText("get__client_ju : ${ctx.client.get__client_ju()}"))
        debugText.add(DebugText("get__client_jv : ${ctx.client.get__client_jv()}"))
        debugText.add(DebugText("get__client_kg : ${ctx.client.get__client_kg()}"))
        debugText.add(DebugText("get__client_kl : ${ctx.client.get__client_kl()}"))
        debugText.add(DebugText("get__client_ko : ${ctx.client.get__client_ko()}"))
        debugText.add(DebugText("get__client_lf : ${ctx.client.get__client_lf()}"))
        debugText.add(DebugText("get__client_lk : ${ctx.client.get__client_lk()}"))
        debugText.add(DebugText("get__client_lm : ${ctx.client.get__client_lm()}"))
        debugText.add(DebugText("get__client_ma : ${ctx.client.get__client_ma()}"))
        debugText.add(DebugText("get__client_mc : ${ctx.client.get__client_mc()}"))
        debugText.add(DebugText("get__client_mi : ${ctx.client.get__client_mi()}"))
        debugText.add(DebugText("get__client_mp : ${ctx.client.get__client_mp()}"))
        debugText.add(DebugText("get__client_ms : ${ctx.client.get__client_ms()}"))
        debugText.add(DebugText("get__client_mv : ${ctx.client.get__client_mv()}"))
        debugText.add(DebugText("get__client_mz : ${ctx.client.get__client_mz()}"))
        debugText.add(DebugText("get__client_na : ${ctx.client.get__client_na()}"))
        debugText.add(DebugText("get__client_nd : ${ctx.client.get__client_nd()}"))
        debugText.add(DebugText("get__client_nj : ${ctx.client.get__client_nj()}"))
        debugText.add(DebugText("get__client_nl : ${ctx.client.get__client_nl()}"))
        debugText.add(DebugText("get__client_nq : ${ctx.client.get__client_nq()}"))
        debugText.add(DebugText("get__client_nw : ${ctx.client.get__client_nw()}"))
        debugText.add(DebugText("get__client_nx : ${ctx.client.get__client_nx()}"))
        debugText.add(DebugText("get__client_oc : ${ctx.client.get__client_oc()}"))
        debugText.add(DebugText("get__client_oe : ${ctx.client.get__client_oe()}"))
        debugText.add(DebugText("get__client_of : ${ctx.client.get__client_of()}"))
        debugText.add(DebugText("get__client_og : ${ctx.client.get__client_og()}"))
        debugText.add(DebugText("get__client_oh : ${ctx.client.get__client_oh()}"))
        debugText.add(DebugText("get__client_ol : ${ctx.client.get__client_ol()}"))
        debugText.add(DebugText("get__client_on : ${ctx.client.get__client_on()}"))
        debugText.add(DebugText("get__client_op : ${ctx.client.get__client_op()}"))
        debugText.add(DebugText("get__client_ou : ${ctx.client.get__client_ou()}"))
        debugText.add(DebugText("get__client_ox : ${ctx.client.get__client_ox()}"))
        debugText.add(DebugText("get__client_oy : ${ctx.client.get__client_oy()}"))
        debugText.add(DebugText("get__client_pg : ${ctx.client.get__client_pg()}"))
        debugText.add(DebugText("get__client_pn : ${ctx.client.get__client_pn()}"))
        debugText.add(DebugText("get__client_pw : ${ctx.client.get__client_pw()}"))
        debugText.add(DebugText("get__client_qe : ${ctx.client.get__client_qe()}"))
        debugText.add(DebugText("get__client_qq : ${ctx.client.get__client_qq()}"))
        debugText.add(DebugText("get__client_sd : ${ctx.client.get__client_sd()}"))
        debugText.add(DebugText("get__client_sh : ${ctx.client.get__client_sh()}"))
        debugText.add(DebugText("get__client_tx : ${ctx.client.get__client_tx()}"))
        debugText.add(DebugText("get__bg_r      : ${ctx.client.get__bg_r()}"))
        debugText.add(DebugText("get__cd_i      : ${ctx.client.get__cd_i()}"))
        debugText.add(DebugText("get__cd_x      : ${ctx.client.get__cd_x()}"))
        debugText.add(DebugText("get__ci_nb     : ${ctx.client.get__ci_nb()}"))
        debugText.add(DebugText("get__ct_aj     : ${ctx.client.get__ct_aj()}"))
        debugText.add(DebugText("get__ct_al     : ${ctx.client.get__ct_al()}"))
        debugText.add(DebugText("get__ct_ar     : ${ctx.client.get__ct_ar()}"))
        debugText.add(DebugText("get__ct_bj     : ${ctx.client.get__ct_bj()}"))
        debugText.add(DebugText("get__ct_bp     : ${ctx.client.get__ct_bp()}"))
        debugText.add(DebugText("get__ct_bq     : ${ctx.client.get__ct_bq()}"))
        debugText.add(DebugText("get__ct_bx     : ${ctx.client.get__ct_bx()}"))
        debugText.add(DebugText("get__ct_f      : ${ctx.client.get__ct_f()}"))
        debugText.add(DebugText("get__ct_x      : ${ctx.client.get__ct_x()}"))
        debugText.add(DebugText("get__cf_bf     : ${ctx.client.get__cf_bf()}"))
        debugText.add(DebugText("get__cs_ey     : ${ctx.client.get__cs_ey()}"))
        debugText.add(DebugText("get__cg_i      : ${ctx.client.get__cg_i()}"))
        debugText.add(DebugText("get__cg_q      : ${ctx.client.get__cg_q()}"))
        debugText.add(DebugText("get__cl_v      : ${ctx.client.get__cl_v()}"))
        debugText.add(DebugText("get__di_b      : ${ctx.client.get__di_b()}"))
        debugText.add(DebugText("get__di_o      : ${ctx.client.get__di_o()}"))
        debugText.add(DebugText("get__dv_gi     : ${ctx.client.get__dv_gi()}"))
        debugText.add(DebugText("get__dv_z      : ${ctx.client.get__dv_z()}"))
        debugText.add(DebugText("get__du_g      : ${ctx.client.get__du_g()}"))
        debugText.add(DebugText("get__du_p      : ${ctx.client.get__du_p()}"))
        debugText.add(DebugText("get__ex_n      : ${ctx.client.get__ex_n()}"))
        debugText.add(DebugText("get__ex_rr     : ${ctx.client.get__ex_rr()}"))
        debugText.add(DebugText("get__eq_cg     : ${ctx.client.get__eq_cg()}"))
        debugText.add(DebugText("get__eq_d      : ${ctx.client.get__eq_d()}"))
        debugText.add(DebugText("get__fc_ih     : ${ctx.client.get__fc_ih()}"))
        debugText.add(DebugText("get__fs_u      : ${ctx.client.get__fs_u()}"))
        debugText.add(DebugText("get__fe_ay     : ${ctx.client.get__fe_ay()}"))
        debugText.add(DebugText("get__fw_ee     : ${ctx.client.get__fw_ee()}"))
        debugText.add(DebugText("get__fh_d      : ${ctx.client.get__fh_d()}"))
        debugText.add(DebugText("get__gm_am     : ${ctx.client.get__gm_am()}"))
        debugText.add(DebugText("get__ge_ak     : ${ctx.client.get__ge_ak()}"))
        debugText.add(DebugText("get__gt_ac     : ${ctx.client.get__gt_ac()}"))
        debugText.add(DebugText("get__gt_e      : ${ctx.client.get__gt_e()}"))
        debugText.add(DebugText("get__gk_j      : ${ctx.client.get__gk_j()}"))
        debugText.add(DebugText("get__gn_gn     : ${ctx.client.get__gn_gn()}"))
        debugText.add(DebugText("get__gy_b      : ${ctx.client.get__gy_b()}"))
        debugText.add(DebugText("get__gy_p      : ${ctx.client.get__gy_p()}"))
        debugText.add(DebugText("get__gy_r      : ${ctx.client.get__gy_r()}"))
        debugText.add(DebugText("get__hy_f      : ${ctx.client.get__hy_f()}"))
        debugText.add(DebugText("get__hy_iq     : ${ctx.client.get__hy_iq()}"))
        debugText.add(DebugText("get__hq_j      : ${ctx.client.get__hq_j()}"))
        debugText.add(DebugText("get__hx_d      : ${ctx.client.get__hx_d()}"))
        debugText.add(DebugText("get__hx_p      : ${ctx.client.get__hx_p()}"))
        debugText.add(DebugText("get__hx_s      : ${ctx.client.get__hx_s()}"))
        debugText.add(DebugText("get__il_j      : ${ctx.client.get__il_j()}"))
        debugText.add(DebugText("get__im_ry     : ${ctx.client.get__im_ry()}"))
        debugText.add(DebugText("get__if_s      : ${ctx.client.get__if_s()}"))
        debugText.add(DebugText("get__ji_b      : ${ctx.client.get__ji_b()}"))
        debugText.add(DebugText("get__jg_f      : ${ctx.client.get__jg_f()}"))
        debugText.add(DebugText("get__jv_al     : ${ctx.client.get__jv_al()}"))
        debugText.add(DebugText("get__jx_a      : ${ctx.client.get__jx_a()}"))
        debugText.add(DebugText("get__jx_n      : ${ctx.client.get__jx_n()}"))
        debugText.add(DebugText("get__lb_rn     : ${ctx.client.get__lb_rn()}"))
        debugText.add(DebugText("get__la_rl     : ${ctx.client.get__la_rl()}"))
        debugText.add(DebugText("get__lh_ru     : ${ctx.client.get__lh_ru()}"))
        debugText.add(DebugText("get__nj_f      : ${ctx.client.get__nj_f()}"))
        debugText.add(DebugText("get__ox_n      : ${ctx.client.get__ox_n()}"))
        debugText.add(DebugText("get__ox_v      : ${ctx.client.get__ox_v()}"))
        debugText.add(DebugText("get__oz_y      : ${ctx.client.get__oz_y()}"))
        ///////////-------------Strings --------------- ///////////////////
//        debugText.add(DebugText("getStrings_login: ${ctx.client.getStrings_login()}"))
//        debugText.add(DebugText("getLogin_response0: ${ctx.client.getLogin_response0()}"))
//        debugText.add(DebugText("getLogin_response0: ${ctx.client.getLogin_response1()}"))
//        debugText.add(DebugText("getLogin_response0: ${ctx.client.getLogin_response2()}"))
//        debugText.add(DebugText("getLogin_response0: ${ctx.client.getLogin_response3()}"))
//        debugText.add(DebugText("getLogin_loadingText: ${ctx.client.getLogin_loadingText()}"))
//        debugText.add(DebugText("getStrings_login: ${ctx.client.getStrings_login()}"))
////        debugText.add(DebugText("login response: ${ctx.client.get__cx_at()}"))
//        debugText.add(DebugText("getLoginState: ${ctx.client.getLoginState()}"))
//        debugText.add(DebugText("getLoginType().get__m(: ${ctx.client.getLoginType().get__t()}"))
//        debugText.add(DebugText("getLoginType().get__n(: ${ctx.client.getLoginType().get__e()}"))
//        debugText.add(DebugText("get__ax_ba     : ${ctx.client.get__ax_ba()}"))
//        debugText.add(DebugText("get__bo_b      : ${ctx.client.get__bo_b()}"))
//        debugText.add(DebugText("get__client_ps : ${ctx.client.get__client_ps()}"))
//        debugText.add(DebugText("get__client_s  : ${ctx.client.get__client_s()}"))
//        debugText.add(DebugText("get__bz_ag     : ${ctx.client.get__bz_ag()}"))
//        debugText.add(DebugText("get__ci_r      : ${ctx.client.get__ci_r()}"))
//        debugText.add(DebugText("get__cj_bc     : ${ctx.client.get__cj_bc()}"))
//        debugText.add(DebugText("get__cj_bg     : ${ctx.client.get__cj_bg()}"))
//        debugText.add(DebugText("get__ff_ah     : ${ctx.client.get__ff_ah()}"))
//        debugText.add(DebugText("get__hn_b      : ${ctx.client.get__hn_b()}"))
//        debugText.add(DebugText("get__hn_f      : ${ctx.client.get__hn_f()}"))
//        debugText.add(DebugText("get__he_aa     : ${ctx.client.get__he_aa()}"))
//        debugText.add(DebugText("get__he_ad     : ${ctx.client.get__he_ad()}"))
//        debugText.add(DebugText("get__he_ae     : ${ctx.client.get__he_ae()}"))
//        debugText.add(DebugText("get__he_ag     : ${ctx.client.get__he_ag()}"))
//        debugText.add(DebugText("get__he_aj     : ${ctx.client.get__he_aj()}"))
//        debugText.add(DebugText("get__he_al     : ${ctx.client.get__he_al()}"))
//        debugText.add(DebugText("get__he_am     : ${ctx.client.get__he_am()}"))
//        debugText.add(DebugText("get__he_an     : ${ctx.client.get__he_an()}"))
//        debugText.add(DebugText("get__he_ap     : ${ctx.client.get__he_ap()}"))
//        debugText.add(DebugText("get__he_aq     : ${ctx.client.get__he_aq()}"))
//        debugText.add(DebugText("get__he_as     : ${ctx.client.get__he_as()}"))
//        debugText.add(DebugText("get__he_at     : ${ctx.client.get__he_at()}"))
//        debugText.add(DebugText("get__he_aw     : ${ctx.client.get__he_aw()}"))
//        debugText.add(DebugText("get__he_ax     : ${ctx.client.get__he_ax()}"))
//        debugText.add(DebugText("get__he_ba     : ${ctx.client.get__he_ba()}"))
//        debugText.add(DebugText("get__he_bb     : ${ctx.client.get__he_bb()}"))
//        debugText.add(DebugText("get__he_bc     : ${ctx.client.get__he_bc()}"))
//        debugText.add(DebugText("get__he_bd     : ${ctx.client.get__he_bd()}"))
//        debugText.add(DebugText("get__he_be     : ${ctx.client.get__he_be()}"))
//        debugText.add(DebugText("get__he_bf     : ${ctx.client.get__he_bf()}"))
//        debugText.add(DebugText("get__he_bg     : ${ctx.client.get__he_bg()}"))
//        debugText.add(DebugText("get__he_bh     : ${ctx.client.get__he_bh()}"))
//        debugText.add(DebugText("get__he_bi     : ${ctx.client.get__he_bi()}"))
//        debugText.add(DebugText("get__he_bj     : ${ctx.client.get__he_bj()}"))
//        debugText.add(DebugText("get__he_bk     : ${ctx.client.get__he_bk()}"))
//        debugText.add(DebugText("get__he_bl     : ${ctx.client.get__he_bl()}"))
//        debugText.add(DebugText("get__he_bm     : ${ctx.client.get__he_bm()}"))
//        debugText.add(DebugText("get__he_bn     : ${ctx.client.get__he_bn()}"))
//        debugText.add(DebugText("get__he_bo     : ${ctx.client.get__he_bo()}"))
//        debugText.add(DebugText("get__he_bp     : ${ctx.client.get__he_bp()}"))
//        debugText.add(DebugText("get__he_bq     : ${ctx.client.get__he_bq()}"))
//        debugText.add(DebugText("get__he_br     : ${ctx.client.get__he_br()}"))
//        debugText.add(DebugText("get__he_bs     : ${ctx.client.get__he_bs()}"))
//        debugText.add(DebugText("get__he_bt     : ${ctx.client.get__he_bt()}"))
//        debugText.add(DebugText("get__he_bu     : ${ctx.client.get__he_bu()}"))
//        debugText.add(DebugText("get__he_bv     : ${ctx.client.get__he_bv()}"))
//        debugText.add(DebugText("get__he_bw     : ${ctx.client.get__he_bw()}"))
//        debugText.add(DebugText("get__he_bx     : ${ctx.client.get__he_bx()}"))
//        debugText.add(DebugText("get__he_by     : ${ctx.client.get__he_by()}"))
//        debugText.add(DebugText("get__he_bz     : ${ctx.client.get__he_bz()}"))
//        debugText.add(DebugText("get__he_c      : ${ctx.client.get__he_c()}"))
//        debugText.add(DebugText("get__he_ca     : ${ctx.client.get__he_ca()}"))
//        debugText.add(DebugText("get__he_cb     : ${ctx.client.get__he_cb()}"))
//        debugText.add(DebugText("get__he_cc     : ${ctx.client.get__he_cc()}"))
//        debugText.add(DebugText("get__he_cd     : ${ctx.client.get__he_cd()}"))
//        debugText.add(DebugText("get__he_ce     : ${ctx.client.get__he_ce()}"))
//        debugText.add(DebugText("get__he_cf     : ${ctx.client.get__he_cf()}"))
//        debugText.add(DebugText("get__he_cg     : ${ctx.client.get__he_cg()}"))
//        debugText.add(DebugText("get__he_ch     : ${ctx.client.get__he_ch()}"))
//        debugText.add(DebugText("get__he_ci     : ${ctx.client.get__he_ci()}"))
//        debugText.add(DebugText("get__he_cj     : ${ctx.client.get__he_cj()}"))
//        debugText.add(DebugText("get__he_ck     : ${ctx.client.get__he_ck()}"))
//        debugText.add(DebugText("get__he_cl     : ${ctx.client.get__he_cl()}"))
//        debugText.add(DebugText("get__he_cm     : ${ctx.client.get__he_cm()}"))
//        debugText.add(DebugText("get__he_cn     : ${ctx.client.get__he_cn()}"))
//        debugText.add(DebugText("get__he_co     : ${ctx.client.get__he_co()}"))
//        debugText.add(DebugText("get__he_cp     : ${ctx.client.get__he_cp()}"))
//        debugText.add(DebugText("get__he_cq     : ${ctx.client.get__he_cq()}"))
//        debugText.add(DebugText("get__he_cr     : ${ctx.client.get__he_cr()}"))
//        debugText.add(DebugText("get__he_cs     : ${ctx.client.get__he_cs()}"))
//        debugText.add(DebugText("get__he_ct     : ${ctx.client.get__he_ct()}"))
//        debugText.add(DebugText("get__he_cu     : ${ctx.client.get__he_cu()}"))
//        debugText.add(DebugText("get__he_cv     : ${ctx.client.get__he_cv()}"))
//        debugText.add(DebugText("get__he_cw     : ${ctx.client.get__he_cw()}"))
//        debugText.add(DebugText("get__he_cx     : ${ctx.client.get__he_cx()}"))
//        debugText.add(DebugText("get__he_cy     : ${ctx.client.get__he_cy()}"))
//        debugText.add(DebugText("get__he_cz     : ${ctx.client.get__he_cz()}"))
//        debugText.add(DebugText("get__he_da     : ${ctx.client.get__he_da()}"))
//        debugText.add(DebugText("get__he_db     : ${ctx.client.get__he_db()}"))
//        debugText.add(DebugText("get__he_dc     : ${ctx.client.get__he_dc()}"))
//        debugText.add(DebugText("get__he_dd     : ${ctx.client.get__he_dd()}"))
//        debugText.add(DebugText("get__he_df     : ${ctx.client.get__he_df()}"))
//        debugText.add(DebugText("get__he_dg     : ${ctx.client.get__he_dg()}"))
//        debugText.add(DebugText("get__he_dh     : ${ctx.client.get__he_dh()}"))
//        debugText.add(DebugText("get__he_di     : ${ctx.client.get__he_di()}"))
//        debugText.add(DebugText("get__he_dj     : ${ctx.client.get__he_dj()}"))
//        debugText.add(DebugText("get__he_dk     : ${ctx.client.get__he_dk()}"))
//        debugText.add(DebugText("get__he_dl     : ${ctx.client.get__he_dl()}"))
//        debugText.add(DebugText("get__he_dm     : ${ctx.client.get__he_dm()}"))
//        debugText.add(DebugText("get__he_dn     : ${ctx.client.get__he_dn()}"))
//        debugText.add(DebugText("get__he_do     : ${ctx.client.get__he_do()}"))
//        debugText.add(DebugText("get__he_dp     : ${ctx.client.get__he_dp()}"))
//        debugText.add(DebugText("get__he_dq     : ${ctx.client.get__he_dq()}"))
//        debugText.add(DebugText("get__he_dr     : ${ctx.client.get__he_dr()}"))
//        debugText.add(DebugText("get__he_ds     : ${ctx.client.get__he_ds()}"))
//        debugText.add(DebugText("get__he_dt     : ${ctx.client.get__he_dt()}"))
//        debugText.add(DebugText("get__he_du     : ${ctx.client.get__he_du()}"))
//        debugText.add(DebugText("get__he_dv     : ${ctx.client.get__he_dv()}"))
//        debugText.add(DebugText("get__he_dx     : ${ctx.client.get__he_dx()}"))
//        debugText.add(DebugText("get__he_dy     : ${ctx.client.get__he_dy()}"))
//        debugText.add(DebugText("get__he_dz     : ${ctx.client.get__he_dz()}"))
//        debugText.add(DebugText("get__he_e      : ${ctx.client.get__he_e()}"))
//        debugText.add(DebugText("get__he_ea     : ${ctx.client.get__he_ea()}"))
//        debugText.add(DebugText("get__he_eb     : ${ctx.client.get__he_eb()}"))
//        debugText.add(DebugText("get__he_ec     : ${ctx.client.get__he_ec()}"))
//        debugText.add(DebugText("get__he_ed     : ${ctx.client.get__he_ed()}"))
//        debugText.add(DebugText("get__he_ef     : ${ctx.client.get__he_ef()}"))
//        debugText.add(DebugText("get__he_eh     : ${ctx.client.get__he_eh()}"))
//        debugText.add(DebugText("get__he_ei     : ${ctx.client.get__he_ei()}"))
//        debugText.add(DebugText("get__he_ej     : ${ctx.client.get__he_ej()}"))
//        debugText.add(DebugText("get__he_ek     : ${ctx.client.get__he_ek()}"))
//        debugText.add(DebugText("get__he_em     : ${ctx.client.get__he_em()}"))
//        debugText.add(DebugText("get__he_en     : ${ctx.client.get__he_en()}"))
//        debugText.add(DebugText("get__he_eo     : ${ctx.client.get__he_eo()}"))
//        debugText.add(DebugText("get__he_ep     : ${ctx.client.get__he_ep()}"))
//        debugText.add(DebugText("get__he_eq     : ${ctx.client.get__he_eq()}"))
//        debugText.add(DebugText("get__he_er     : ${ctx.client.get__he_er()}"))
//        debugText.add(DebugText("get__he_et     : ${ctx.client.get__he_et()}"))
//        debugText.add(DebugText("get__he_eu     : ${ctx.client.get__he_eu()}"))
//        debugText.add(DebugText("get__he_ew     : ${ctx.client.get__he_ew()}"))
//        debugText.add(DebugText("get__he_ex     : ${ctx.client.get__he_ex()}"))
//        debugText.add(DebugText("get__he_ey     : ${ctx.client.get__he_ey()}"))
//        debugText.add(DebugText("get__he_ez     : ${ctx.client.get__he_ez()}"))
//        debugText.add(DebugText("get__he_fa     : ${ctx.client.get__he_fa()}"))
//        debugText.add(DebugText("get__he_fc     : ${ctx.client.get__he_fc()}"))
//        debugText.add(DebugText("get__he_fg     : ${ctx.client.get__he_fg()}"))
//        debugText.add(DebugText("get__he_fh     : ${ctx.client.get__he_fh()}"))
//        debugText.add(DebugText("get__he_fk     : ${ctx.client.get__he_fk()}"))
//        debugText.add(DebugText("get__he_fl     : ${ctx.client.get__he_fl()}"))
//        debugText.add(DebugText("get__he_fm     : ${ctx.client.get__he_fm()}"))
//        debugText.add(DebugText("get__he_fu     : ${ctx.client.get__he_fu()}"))
//        debugText.add(DebugText("get__he_fv     : ${ctx.client.get__he_fv()}"))
//        debugText.add(DebugText("get__he_fz     : ${ctx.client.get__he_fz()}"))
//        debugText.add(DebugText("get__he_ga     : ${ctx.client.get__he_ga()}"))
//        debugText.add(DebugText("get__he_gb     : ${ctx.client.get__he_gb()}"))
//        debugText.add(DebugText("get__he_gc     : ${ctx.client.get__he_gc()}"))
//        debugText.add(DebugText("get__he_gd     : ${ctx.client.get__he_gd()}"))
//        debugText.add(DebugText("get__he_ge     : ${ctx.client.get__he_ge()}"))
//        debugText.add(DebugText("get__he_gf     : ${ctx.client.get__he_gf()}"))
//        debugText.add(DebugText("get__he_gg     : ${ctx.client.get__he_gg()}"))
//        debugText.add(DebugText("get__he_gh     : ${ctx.client.get__he_gh()}"))
//        debugText.add(DebugText("get__he_gi     : ${ctx.client.get__he_gi()}"))
//        debugText.add(DebugText("get__he_gj     : ${ctx.client.get__he_gj()}"))
//        debugText.add(DebugText("get__he_gk     : ${ctx.client.get__he_gk()}"))
//        debugText.add(DebugText("get__he_gl     : ${ctx.client.get__he_gl()}"))
//        debugText.add(DebugText("get__he_gm     : ${ctx.client.get__he_gm()}"))
//        debugText.add(DebugText("get__he_gn     : ${ctx.client.get__he_gn()}"))
//        debugText.add(DebugText("get__he_go     : ${ctx.client.get__he_go()}"))
//        debugText.add(DebugText("get__he_gp     : ${ctx.client.get__he_gp()}"))
//        debugText.add(DebugText("get__he_gq     : ${ctx.client.get__he_gq()}"))
//        debugText.add(DebugText("get__he_gr     : ${ctx.client.get__he_gr()}"))
//        debugText.add(DebugText("get__he_gs     : ${ctx.client.get__he_gs()}"))
//        debugText.add(DebugText("get__he_gt     : ${ctx.client.get__he_gt()}"))
//        debugText.add(DebugText("get__he_gu     : ${ctx.client.get__he_gu()}"))
//        debugText.add(DebugText("get__he_gv     : ${ctx.client.get__he_gv()}"))
//        debugText.add(DebugText("get__he_gw     : ${ctx.client.get__he_gw()}"))
//        debugText.add(DebugText("get__he_gx     : ${ctx.client.get__he_gx()}"))
//        debugText.add(DebugText("get__he_gy     : ${ctx.client.get__he_gy()}"))
//        debugText.add(DebugText("get__he_gz     : ${ctx.client.get__he_gz()}"))
//        debugText.add(DebugText("get__he_hb     : ${ctx.client.get__he_hb()}"))
//        debugText.add(DebugText("get__he_hd     : ${ctx.client.get__he_hd()}"))
//        debugText.add(DebugText("get__he_he     : ${ctx.client.get__he_he()}"))
//        debugText.add(DebugText("get__he_hf     : ${ctx.client.get__he_hf()}"))
//        debugText.add(DebugText("get__he_hg     : ${ctx.client.get__he_hg()}"))
//        debugText.add(DebugText("get__he_hh     : ${ctx.client.get__he_hh()}"))
//        debugText.add(DebugText("get__he_hj     : ${ctx.client.get__he_hj()}"))
//        debugText.add(DebugText("get__he_hk     : ${ctx.client.get__he_hk()}"))
//        debugText.add(DebugText("get__he_hl     : ${ctx.client.get__he_hl()}"))
//        debugText.add(DebugText("get__he_hn     : ${ctx.client.get__he_hn()}"))
//        debugText.add(DebugText("get__he_hq     : ${ctx.client.get__he_hq()}"))
//        debugText.add(DebugText("get__he_hv     : ${ctx.client.get__he_hv()}"))
//        debugText.add(DebugText("get__he_hy     : ${ctx.client.get__he_hy()}"))
//        debugText.add(DebugText("get__he_hz     : ${ctx.client.get__he_hz()}"))
//        debugText.add(DebugText("get__he_ia     : ${ctx.client.get__he_ia()}"))
//        debugText.add(DebugText("get__he_ic     : ${ctx.client.get__he_ic()}"))
//        debugText.add(DebugText("get__he_ie     : ${ctx.client.get__he_ie()}"))
//        debugText.add(DebugText("get__he_if     : ${ctx.client.get__he_if()}"))
//        debugText.add(DebugText("get__he_ig     : ${ctx.client.get__he_ig()}"))
//        debugText.add(DebugText("get__he_ih     : ${ctx.client.get__he_ih()}"))
//        debugText.add(DebugText("get__he_ii     : ${ctx.client.get__he_ii()}"))
//        debugText.add(DebugText("get__he_ij     : ${ctx.client.get__he_ij()}"))
//        debugText.add(DebugText("get__he_ik     : ${ctx.client.get__he_ik()}"))
//        debugText.add(DebugText("get__he_im     : ${ctx.client.get__he_im()}"))
//        debugText.add(DebugText("get__he_in     : ${ctx.client.get__he_in()}"))
//        debugText.add(DebugText("get__he_io     : ${ctx.client.get__he_io()}"))
//        debugText.add(DebugText("get__he_ip     : ${ctx.client.get__he_ip()}"))
//        debugText.add(DebugText("get__he_iq     : ${ctx.client.get__he_iq()}"))
//        debugText.add(DebugText("get__he_it     : ${ctx.client.get__he_it()}"))
//        debugText.add(DebugText("get__he_iu     : ${ctx.client.get__he_iu()}"))
//        debugText.add(DebugText("get__he_ix     : ${ctx.client.get__he_ix()}"))
//        debugText.add(DebugText("get__he_iy     : ${ctx.client.get__he_iy()}"))
//        debugText.add(DebugText("get__he_ja     : ${ctx.client.get__he_ja()}"))
//        debugText.add(DebugText("get__he_jb     : ${ctx.client.get__he_jb()}"))
//        debugText.add(DebugText("get__he_jc     : ${ctx.client.get__he_jc()}"))
//        debugText.add(DebugText("get__he_jd     : ${ctx.client.get__he_jd()}"))
//        debugText.add(DebugText("get__he_je     : ${ctx.client.get__he_je()}"))
//        debugText.add(DebugText("get__he_jf     : ${ctx.client.get__he_jf()}"))
//        debugText.add(DebugText("get__he_jg     : ${ctx.client.get__he_jg()}"))
//        debugText.add(DebugText("get__he_jh     : ${ctx.client.get__he_jh()}"))
//        debugText.add(DebugText("get__he_ji     : ${ctx.client.get__he_ji()}"))
//        debugText.add(DebugText("get__he_jj     : ${ctx.client.get__he_jj()}"))
//        debugText.add(DebugText("get__he_jk     : ${ctx.client.get__he_jk()}"))
//        debugText.add(DebugText("get__he_jl     : ${ctx.client.get__he_jl()}"))
//        debugText.add(DebugText("get__he_jm     : ${ctx.client.get__he_jm()}"))
//        debugText.add(DebugText("get__he_jn     : ${ctx.client.get__he_jn()}"))
//        debugText.add(DebugText("get__he_jo     : ${ctx.client.get__he_jo()}"))
//        debugText.add(DebugText("get__he_jp     : ${ctx.client.get__he_jp()}"))
//        debugText.add(DebugText("get__he_jq     : ${ctx.client.get__he_jq()}"))
//        debugText.add(DebugText("get__he_jr     : ${ctx.client.get__he_jr()}"))
//        debugText.add(DebugText("get__he_js     : ${ctx.client.get__he_js()}"))
//        debugText.add(DebugText("get__he_jt     : ${ctx.client.get__he_jt()}"))
//        debugText.add(DebugText("get__he_ju     : ${ctx.client.get__he_ju()}"))
//        debugText.add(DebugText("get__he_jv     : ${ctx.client.get__he_jv()}"))
//        debugText.add(DebugText("get__he_jw     : ${ctx.client.get__he_jw()}"))
//        debugText.add(DebugText("get__he_jx     : ${ctx.client.get__he_jx()}"))
//        debugText.add(DebugText("get__he_jy     : ${ctx.client.get__he_jy()}"))
//        debugText.add(DebugText("get__he_jz     : ${ctx.client.get__he_jz()}"))
//        debugText.add(DebugText("get__he_ka     : ${ctx.client.get__he_ka()}"))
//        debugText.add(DebugText("get__he_kd     : ${ctx.client.get__he_kd()}"))
//        debugText.add(DebugText("get__he_ke     : ${ctx.client.get__he_ke()}"))
//        debugText.add(DebugText("get__he_kf     : ${ctx.client.get__he_kf()}"))
//        debugText.add(DebugText("get__he_kg     : ${ctx.client.get__he_kg()}"))
//        debugText.add(DebugText("get__he_ki     : ${ctx.client.get__he_ki()}"))
//        debugText.add(DebugText("get__he_kk     : ${ctx.client.get__he_kk()}"))
//        debugText.add(DebugText("get__he_kl     : ${ctx.client.get__he_kl()}"))
//        debugText.add(DebugText("get__he_km     : ${ctx.client.get__he_km()}"))
//        debugText.add(DebugText("get__he_ko     : ${ctx.client.get__he_ko()}"))
//        debugText.add(DebugText("get__he_kt     : ${ctx.client.get__he_kt()}"))
//        debugText.add(DebugText("get__he_ku     : ${ctx.client.get__he_ku()}"))
//        debugText.add(DebugText("get__he_kv     : ${ctx.client.get__he_kv()}"))
//        debugText.add(DebugText("get__he_kw     : ${ctx.client.get__he_kw()}"))
//        debugText.add(DebugText("get__he_kx     : ${ctx.client.get__he_kx()}"))
//        debugText.add(DebugText("get__he_kz     : ${ctx.client.get__he_kz()}"))
//        debugText.add(DebugText("get__he_t      : ${ctx.client.get__he_t()}"))
//        debugText.add(DebugText("get__he_ai     : ${ctx.client.get__he_ai()}"))
//        debugText.add(DebugText("get__jd_bb     : ${ctx.client.get__jd_bb()}"))




//        debugText.add(DebugText("clientData.loginState :${ctx.client.get__a}"))


        val yBase = 70
        var x = 50
        var y = yBase
        var bannedY = 10
        var bannedX = 50
        val savedFont = g.font
        g.font = Font("Consolas", Font.PLAIN, 10)
        debugText.forEachIndexed { index, debugText ->
            g.color = Color.ORANGE

            g.drawString(debugText.text, x, y)
            //Loginto a banned account and we can get this result
            if(debugText.text.contains("12")){
                g.drawString(debugText.text, bannedX, bannedY)
                bannedY+= 15
            }
            y += 15
            if(index > 0 && index % 40 == 0){
                y = yBase
                x += 250
            }
        }
        g.font = savedFont
    }


}
